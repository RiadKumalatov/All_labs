package client1;

import org.camunda.bpm.client.ExternalTaskClient;

import java.awt.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ReservationServiceClient {
    private static URL getWSDLURL(String urlStr) {
        URL url = null;
        try {
            url = new URL(urlStr);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return url;
    }

    public void processURL(URL url) {

        ExternalTaskClient client = ExternalTaskClient.create()
                .baseUrl("http://localhost:8080/engine-rest")
                .asyncResponseTimeout(10000) // long polling timeout
                .build();

        client.subscribe("TopicReservation")
                .lockDuration(1000) // the default lock duration is 20 seconds, but you can override this
                .handler((externalTask, externalTaskService) -> {

                    try {
                        Desktop.getDesktop().browse(new URI("https://docs.camunda.org/get-started/quick-start/complete"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //

                    ReservationService_Service reservationService_service = new ReservationService_Service(url);
                    ReservationService reservationService = reservationService_service.getReservationServicePort();

                    String userName = "Kolesnikova Olga";
                    int number = 1;

                    Reservation reservation = reservationService.reserveTable(userName, number);

                    System.out.println("Dear " + userName + "! Our best table was reserved specially for you and your friends! :)");
                    System.out.println("Thank you! For choosing our restaurant! :D");

                    // System.out.println(reservation.getReservationTable().getTableNumber());

                    Map<String, Object> variables = new HashMap<>();
                    variables.put("User", reservation.getReservationUser());
                    variables.put("Cost", reservation.getReservationCost());
                    variables.put("tableFloor", reservation.getReservationTable().getTableFloor());
                    variables.put("tableNumber", reservation.getReservationTable().getTableNumber());
                    variables.put("tablePlaces", reservation.getReservationTable().getTablePlaces());

                    // Complete the task
                    externalTaskService.complete(externalTask, variables);
                })
                .open();
    }

    public static void main(String[] args) {
        URL url = getWSDLURL("http://localhost:8081/Reserve?wsdl");
        ReservationServiceClient client = new ReservationServiceClient();
        client.processURL(url);
    }
}
