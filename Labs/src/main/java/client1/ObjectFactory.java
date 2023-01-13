
package client1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the client1 package. 
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

    private final static QName _ReserveTableResponse_QNAME = new QName("http://services/", "ReserveTableResponse");
    private final static QName _ReserveTable_QNAME = new QName("http://services/", "ReserveTable");
    private final static QName _GenerateTables_QNAME = new QName("http://services/", "generateTables");
    private final static QName _GenerateTablesResponse_QNAME = new QName("http://services/", "generateTablesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: client1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GenerateTables }
     * 
     */
    public GenerateTables createGenerateTables() {
        return new GenerateTables();
    }

    /**
     * Create an instance of {@link GenerateTablesResponse }
     * 
     */
    public GenerateTablesResponse createGenerateTablesResponse() {
        return new GenerateTablesResponse();
    }

    /**
     * Create an instance of {@link ReserveTableResponse }
     * 
     */
    public ReserveTableResponse createReserveTableResponse() {
        return new ReserveTableResponse();
    }

    /**
     * Create an instance of {@link ReserveTable }
     * 
     */
    public ReserveTable createReserveTable() {
        return new ReserveTable();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ReserveTableResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "ReserveTableResponse")
    public JAXBElement<ReserveTableResponse> createReserveTableResponse(ReserveTableResponse value) {
        return new JAXBElement<ReserveTableResponse>(_ReserveTableResponse_QNAME, ReserveTableResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReserveTable }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "ReserveTable")
    public JAXBElement<ReserveTable> createReserveTable(ReserveTable value) {
        return new JAXBElement<ReserveTable>(_ReserveTable_QNAME, ReserveTable.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerateTables }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "generateTables")
    public JAXBElement<GenerateTables> createGenerateTables(GenerateTables value) {
        return new JAXBElement<GenerateTables>(_GenerateTables_QNAME, GenerateTables.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerateTablesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "generateTablesResponse")
    public JAXBElement<GenerateTablesResponse> createGenerateTablesResponse(GenerateTablesResponse value) {
        return new JAXBElement<GenerateTablesResponse>(_GenerateTablesResponse_QNAME, GenerateTablesResponse.class, null, value);
    }

}
