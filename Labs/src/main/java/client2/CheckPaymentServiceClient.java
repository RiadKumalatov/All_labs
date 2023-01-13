package client2;


import client1.ReservationService;
import client1.ReservationService_Service;
import org.camunda.bpm.client.ExternalTaskClient;
import org.camunda.bpm.client.task.ExternalTask;

import javax.xml.ws.Response;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutionException;

public class CheckPaymentServiceClient {

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
    private void processURL(URL url) {

        ExternalTaskClient client = ExternalTaskClient.create()
                .baseUrl("http://localhost:8080/engine-rest")
                .asyncResponseTimeout(10000) // long polling timeout
                .build();

        client.subscribe("TopicPrePayment")
                .lockDuration(1000) // the default lock duration is 20 seconds, but you can override this
                .handler((externalTask, externalTaskService) -> {

                    try {
                        Desktop.getDesktop().browse(new URI("https://docs.camunda.org/get-started/quick-start/complete"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //

                    CheckPayment checkPayment = new CheckPayment(url);
                    CheckPaymentService checkPaymentService = checkPayment.getCheckPaymentPort();

                    Reservation reservation = new Reservation();
                    String userName = externalTask.getVariable("User");
                    int cost = externalTask.getVariable("Cost");
                    int tableNumber = externalTask.getVariable("tableNumber");
                    int tableFloor = externalTask.getVariable("tableFloor");
                    int tablePlaces = externalTask.getVariable("tablePlaces");

                    Table table = new Table();
                    table.setTableFloor(tableFloor);
                    table.setTableNumber(tableNumber);
                    table.setTablePlaces(tablePlaces);
                    reservation.setReservationCost(cost);
                    reservation.setReservationUser(userName);
                    reservation.setReservationTable(table);

                    Random random = new Random();
                    boolean confirm = random.nextBoolean();

                    Response<ConfirmPaymentResponse> response = checkPaymentService.confirmPaymentAsync(reservation, confirm);
                    System.out.println("Polling started");
                    while(!response.isDone()) {
                        try {
                            System.out.println("Polling...");
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Prepayment prepayment = new Prepayment();
                    try {

                        prepayment = response.get().getReturn();
                        System.out.println("Prepayment amount " + prepayment.getAmount());
                        if (prepayment.isConfirm()) {
                            System.out.println("Prepayment was confirmed");
                        }
                        else {
                            System.out.println("Prepayment was not confirmed");
                        }
                        // Complete the task

                        System.out.println(prepayment.isConfirm());

                    } catch (ExecutionException e) {
                        throw new RuntimeException(e);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    Map<String, Object> variables = new HashMap<>();
                    variables.put("prePayment", true);
                    externalTaskService.complete(externalTask, variables);
                })
                .open();
    }

    public static void main(String[] args) {
        URL url = getWSDLURL("http://localhost:8082/Check?wsdl");
        CheckPaymentServiceClient client = new CheckPaymentServiceClient();
        client.processURL(url);
    }

}
