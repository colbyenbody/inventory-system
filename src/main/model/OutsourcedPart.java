
package main.model;

/**
 * Models an outsourced part
 *
 * @author Colby Enbody
 */

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class OutsourcedPart extends Part {

    private final StringProperty companyName;

    /**
     * Constructor for a new instance of an Outsourced part.
     *
     * @param partID ID for the part
     * @param name name of the part
     * @param price price of the part
     * @param inStock inventory level of the part
     * @param min minimum level for the part
     * @param max maximum level for the part
     * @param companyName the company name for the part
     */

    public OutsourcedPart(int partID, String name, double price, int inStock, int min, int max, String companyName) {
        this.partID = new SimpleIntegerProperty(partID);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleDoubleProperty(price);
        this.inStock = new SimpleIntegerProperty(inStock);
        this.min = new SimpleIntegerProperty(min);
        this.max = new SimpleIntegerProperty(max);
        this.companyName = new SimpleStringProperty(companyName);
    }

    public OutsourcedPart() {
        this.partID = new SimpleIntegerProperty(0);
        this.name = new SimpleStringProperty("");
        this.price = new SimpleDoubleProperty(0);
        this.inStock = new SimpleIntegerProperty(0);
        this.min = new SimpleIntegerProperty(0);
        this.max = new SimpleIntegerProperty(0);
        this.companyName = new SimpleStringProperty("");
    }

    /**
     * Getter for the companyName
     * @return
     */
    public String getCompanyName() {
        return this.companyName.get();
    }
    /**
     * The setter for the companyName
     * @param companyName
     */
    public void setCompanyName(String companyName) {
        this.companyName.set(companyName);
    }
    
    public StringProperty companyNameProperty() {
            return companyName;
    }
}