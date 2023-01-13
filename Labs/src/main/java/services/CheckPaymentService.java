package services;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

@WebService(serviceName = "CheckPayment", portName = "CheckPaymentPort")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class CheckPaymentService {

    @WebMethod(operationName = "ConfirmPayment")
    public Prepayment confirmPayment(Reservation reservation, boolean confirm) {

        try {
            Thread.sleep(1000 * 5);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        Prepayment prepayment = new Prepayment();
        prepayment.setReservation(reservation);
        prepayment.setAmount(reservation.getReservationCost());
        if (confirm) {
            prepayment.setConfirm(true);
            System.out.println("Payment was confirmed");
        }
        else {
            prepayment.setConfirm(false);
            System.out.println("Payment was not confirmed");
        }
        return prepayment;
    }

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8082/Check", new CheckPaymentService());
    }

}
