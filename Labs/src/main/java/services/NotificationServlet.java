package services;

import client1.ReservationService;
import client1.ReservationService_Service;
import org.camunda.bpm.client.ExternalTaskClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Path("/note")
public class NotificationServlet {

    String userName;

    @GET
    @Path("/confirm")
    @Produces(MediaType.APPLICATION_JSON)
    public Response noteUser() throws IOException {
        String message = null;

        Reservation reservation = new Reservation();
        reservation.setReservationCost(500);
        reservation.setReservationUser("Kolesnikova Olga");
        Table table = new Table();
        table.setTableNumber(1);
        table.setTableFloor(1);
        table.setTablePlaces(8);
        reservation.setReservationTable(table);
        Prepayment prepayment = new Prepayment();
        prepayment.setConfirm(true);
        prepayment.setAmount(100);
        prepayment.setReservation(reservation);

        message = "Dear " + prepayment.getReservation().getReservationUser() + "! Your reservation was confirmed! \n" +
                "We are happy to welcome you at our restaurant! :)";

        // URL url = "http://localhost:9090/app/rest/note/confirm"

        ExternalTaskClient client = ExternalTaskClient.create()
                .baseUrl("http://localhost:8080/engine-rest")
                .asyncResponseTimeout(10000) // long polling timeout
                .build();

        client.subscribe("TopicNotification")
                .lockDuration(1000) // the default lock duration is 20 seconds, but you can override this
                .handler((externalTask, externalTaskService) -> {

                    try {
                        Desktop.getDesktop().browse(new URI("https://docs.camunda.org/get-started/quick-start/complete"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    userName = externalTask.getVariable("User");
                    // Complete the task
                    externalTaskService.complete(externalTask);
                })
                .open();

        return Response.ok(message).build();
    }
}
