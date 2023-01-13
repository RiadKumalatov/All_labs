
package client2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the client2 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ConfirmPayment_QNAME = new QName("http://services/", "ConfirmPayment");
    private final static QName _ConfirmPaymentResponse_QNAME = new QName("http://services/", "ConfirmPaymentResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: client2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConfirmPaymentResponse }
     * 
     */
    public ConfirmPaymentResponse createConfirmPaymentResponse() {
        return new ConfirmPaymentResponse();
    }

    /**
     * Create an instance of {@link ConfirmPayment }
     * 
     */
    public ConfirmPayment createConfirmPayment() {
        return new ConfirmPayment();
    }

    /**
     * Create an instance of {@link Reservation }
     * 
     */
    public Reservation createReservation() {
        return new Reservation();
    }

    /**
     * Create an instance of {@link Table }
     * 
     */
    public Table createTable() {
        return new Table();
    }

    /**
     * Create an instance of {@link Prepayment }
     * 
     */
    public Prepayment createPrepayment() {
        return new Prepayment();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfirmPayment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "ConfirmPayment")
    public JAXBElement<ConfirmPayment> createConfirmPayment(ConfirmPayment value) {
        return new JAXBElement<ConfirmPayment>(_ConfirmPayment_QNAME, ConfirmPayment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfirmPaymentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "ConfirmPaymentResponse")
    public JAXBElement<ConfirmPaymentResponse> createConfirmPaymentResponse(ConfirmPaymentResponse value) {
        return new JAXBElement<ConfirmPaymentResponse>(_ConfirmPaymentResponse_QNAME, ConfirmPaymentResponse.class, null, value);
    }

}
