
package client2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for prepayment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="prepayment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="confirm" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="reservation" type="{http://services/}reservation" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "prepayment", propOrder = {
    "amount",
    "confirm",
    "reservation"
})
public class Prepayment {

    protected int amount;
    protected boolean confirm;
    protected Reservation reservation;

    /**
     * Gets the value of the amount property.
     * 
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     */
    public void setAmount(int value) {
        this.amount = value;
    }

    /**
     * Gets the value of the confirm property.
     * 
     */
    public boolean isConfirm() {
        return confirm;
    }

    /**
     * Sets the value of the confirm property.
     * 
     */
    public void setConfirm(boolean value) {
        this.confirm = value;
    }

    /**
     * Gets the value of the reservation property.
     * 
     * @return
     *     possible object is
     *     {@link Reservation }
     *     
     */
    public Reservation getReservation() {
        return reservation;
    }

    /**
     * Sets the value of the reservation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Reservation }
     *     
     */
    public void setReservation(Reservation value) {
        this.reservation = value;
    }

}
