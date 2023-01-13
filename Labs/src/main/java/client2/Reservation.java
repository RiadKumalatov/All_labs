
package client2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for reservation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="reservation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="reservationCost" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="reservationTable" type="{http://services/}table" minOccurs="0"/>
 *         &lt;element name="reservationUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reservation", propOrder = {
    "reservationCost",
    "reservationTable",
    "reservationUser"
})
public class Reservation {

    protected int reservationCost;
    protected Table reservationTable;
    protected String reservationUser;

    /**
     * Gets the value of the reservationCost property.
     * 
     */
    public int getReservationCost() {
        return reservationCost;
    }

    /**
     * Sets the value of the reservationCost property.
     * 
     */
    public void setReservationCost(int value) {
        this.reservationCost = value;
    }

    /**
     * Gets the value of the reservationTable property.
     * 
     * @return
     *     possible object is
     *     {@link Table }
     *     
     */
    public Table getReservationTable() {
        return reservationTable;
    }

    /**
     * Sets the value of the reservationTable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Table }
     *     
     */
    public void setReservationTable(Table value) {
        this.reservationTable = value;
    }

    /**
     * Gets the value of the reservationUser property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReservationUser() {
        return reservationUser;
    }

    /**
     * Sets the value of the reservationUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReservationUser(String value) {
        this.reservationUser = value;
    }

}
