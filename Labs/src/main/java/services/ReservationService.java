package services;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;
import java.util.ArrayList;
import java.util.Random;

@WebService(serviceName = "ReservationService", portName = "ReservationServicePort")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class ReservationService {
    public ArrayList<Table> generateTables() {
        ArrayList<Table> tables = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 4; i ++) {
            Table table = new Table();
            table.setTableNumber(i);
            int floor = random.nextInt(3);
            table.setTableFloor(floor);
            int places = random.nextInt(8);
            table.setTablePlaces(places);
            tables.add(table);
        }
        return tables;
    }

    @WebMethod(operationName = "ReserveTable")
    public Reservation reserveTable(String userName, int numberOfPeople) {
        Reservation reservation = new Reservation();
        Random random = new Random();
        ArrayList<Table> tables = generateTables();
        for (Table table : tables)
            if (table.getTablePlaces() >= numberOfPeople) {
                reservation.setReservationTable(table);
            }
        int cost = random.nextInt(10) * 100;
        reservation.setReservationUser(userName);
        reservation.setReservationCost(cost);
        return reservation;
    }

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8081/Reserve", new ReservationService());
    }
}
