
package client1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for table complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="table">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tableFloor" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tableNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tablePlaces" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "table", propOrder = {
    "tableFloor",
    "tableNumber",
    "tablePlaces"
})
public class Table {

    protected int tableFloor;
    protected int tableNumber;
    protected int tablePlaces;

    /**
     * Gets the value of the tableFloor property.
     * 
     */
    public int getTableFloor() {
        return tableFloor;
    }

    /**
     * Sets the value of the tableFloor property.
     * 
     */
    public void setTableFloor(int value) {
        this.tableFloor = value;
    }

    /**
     * Gets the value of the tableNumber property.
     * 
     */
    public int getTableNumber() {
        return tableNumber;
    }

    /**
     * Sets the value of the tableNumber property.
     * 
     */
    public void setTableNumber(int value) {
        this.tableNumber = value;
    }

    /**
     * Gets the value of the tablePlaces property.
     * 
     */
    public int getTablePlaces() {
        return tablePlaces;
    }

    /**
     * Sets the value of the tablePlaces property.
     * 
     */
    public void setTablePlaces(int value) {
        this.tablePlaces = value;
    }

}
