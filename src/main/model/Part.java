/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.model;

/**
 *
 * @author Colby Enbody
 */

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public abstract class Part {

    protected IntegerProperty partID;
    protected StringProperty name;
    protected DoubleProperty price;
    protected IntegerProperty inStock;
    protected IntegerProperty min;
    protected IntegerProperty max;

    /**
     * @param partID the id to set
     */
    public void setPartID(int partID) {
        this.partID.set(partID);
    }

    /**
     * @return partID
     */
    public int getPartID() { return this.partID.get();
    }
    
    public IntegerProperty partIDProperty() {
        return partID;
    }

    /**
     * @param name the name to set
     */

    public void setName(String name) {
        this.name.set(name);
    }

    /**
     * @return the name
     */

    public String getName() {
        return this.name.get();
    }
    
    public StringProperty nameProperty() {
        return name;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price.set(price);
    }
    /**
     * @return the price
     */
    public double getPrice() {
        return this.price.get();
    }
    
    public DoubleProperty priceProperty() {
        return price;
    }

    /**
     * @param inStock the stock to set
     */
    public void setInStock(int inStock) {
        this.inStock.set(inStock);
    }
    /**
     * @return the stock
     */
    public int getInStock() {
        return this.inStock.get();
    }
    
    public IntegerProperty inStockProperty() {
        return inStock;
    }

    /**
     * @param min the min to set
     */
    public void setMin(int min) {
        this.min.set(min);
    }
    /**
     * @return the min
     */
    public int getMin() {
        return this.min.get();
    }
    
    public IntegerProperty minProperty() {
        return min;
    }

    /**
     * @param max the max to set
     */
    public void setMax(int max) {
        this.max.set(max);
    }
    /**
     * @return the max
     */
    public int getMax() {
        return this.max.get();
    }
    
    public IntegerProperty maxProperty() {
        return max;
    }
}
