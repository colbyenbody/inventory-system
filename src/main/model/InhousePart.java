
package main.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Models an inhouse part
 * @author Colby Enbody
 *
 */
public class InhousePart extends Part {
    /**
     * The machineID for the part
     */
    private final IntegerProperty machineID;
    /**
     * Constructor for a new instance of an Inhouse object
     * @param partID the ID for the part
     * @param name the name of the part
     * @param price the price of the part
     * @param inStock the inventory level of the part
     * @param min the minimum level for the part
     * @param max the maximum level for the part
     * @param machineID the machine ID for the part
     */
    public InhousePart(int partID, String name, double price, int inStock, int min, int max, int machineID) {
        this.partID = new SimpleIntegerProperty(partID);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleDoubleProperty(price);
        this.inStock = new SimpleIntegerProperty(inStock);
        this.min = new SimpleIntegerProperty(min);
        this.max = new SimpleIntegerProperty(max);
        this.machineID = new SimpleIntegerProperty(machineID);
    }

    public InhousePart() {
        this.partID = new SimpleIntegerProperty(0);
        this.name = new SimpleStringProperty("");
        this.price = new SimpleDoubleProperty(0);
        this.inStock = new SimpleIntegerProperty(0);
        this.min = new SimpleIntegerProperty(0);
        this.max = new SimpleIntegerProperty(0);
        this.machineID = new SimpleIntegerProperty(0);
    }


    /**
     * Getter for the machineID
     * @return machineID of the part
     */
    public int getMachineID() {
        return this.machineID.get();
    }

    /**
     * Setter for the machineID
     * @param machineID the machineId of the part
     */
    public void setMachineID(int machineID) {
        this.machineID.set(machineID);
    }
    
    public IntegerProperty machineIDProperty(){
        return machineID;
    }
}
