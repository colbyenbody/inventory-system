/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.model;

import java.util.ArrayList;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Colby Enbody
 *
 */

public class Product {

    private ArrayList<Part> associatedParts;
    private final IntegerProperty productID;
    private final StringProperty productName;
    private final DoubleProperty productPrice;
    private final IntegerProperty productInStock;
    private final IntegerProperty productMin;
    private final IntegerProperty productMax;

    /**
     * Constructor for a new instance of a product
     *
     * @param productID the ID for the product
     * @param name the name of the product
     * @param price the price of the product
     * @param inStock the inventory level of the product
     * @param min the minimum level for the product
     * @param max the maximum level for the product
     */

    public Product(int productID, String name, double price, int inStock, int min, int max, ArrayList<Part> associatedParts) {
        this.productID = new SimpleIntegerProperty(productID);
        this.productName = new SimpleStringProperty(name);
        this.productPrice = new SimpleDoubleProperty(price);
        this.productInStock = new SimpleIntegerProperty(inStock);
        this.productMin = new SimpleIntegerProperty(min);
        this.productMax = new SimpleIntegerProperty(max);
        this.associatedParts = new ArrayList<>(associatedParts);
    }

    public Product() {
        this.productID = new SimpleIntegerProperty(0);
        this.productName = new SimpleStringProperty("");
        this.productPrice = new SimpleDoubleProperty(0);
        this.productInStock = new SimpleIntegerProperty(0);
        this.productMin = new SimpleIntegerProperty(0);
        this.productMax = new SimpleIntegerProperty(0);
        this.associatedParts = new ArrayList<>();

    }

    /**
     * Setter for the id
     * @param productID the id of the product
     */
    public void setProductID(int productID) {
        this.productID.set(productID);
    }
    /**
     * Getter for the id
     * @return id of the product
     */
    public int getProductID() {
        return this.productID.get();
    }

    public IntegerProperty productIDProperty() {
        return productID;
    }

    /**
     * Setter for the name
     * @param name The name of the product
     */
     public void setName(String name) {
        this.productName.set(name);
    }
    /**
     * Getter for the name
     * @return name of the product
     */
    public String getName() {
        return this.productName.get();
    }

    public StringProperty productNameProperty() {
        return productName;
    }

    /**
     * Setter for the price
     * @param price The price of the product
     */
    public void setPrice(double price) {
        this.productPrice.set(price);
    }
    /**
     * Getter for the price
     * @return price of the product
     */
    public double getPrice() {
        return this.productPrice.get();
    }

    public DoubleProperty productPriceProperty() {
        return productPrice;
    }

    /**
     * Setter for the stock
     * @param  inStock The inventory level of the product
     */
    public void setInStock(int inStock) {
        this.productInStock.set(inStock);
    }
    /**
     * Getter for the stock
     * @return the stock of the product
     */
    public int getInStock() {
        return this.productInStock.get();
    }

    public IntegerProperty productInStockProperty() {
        return productInStock;
    }

    /**
     * Setter for the min
     * @param min The minimum level for the product
     */
    public void setMin(int min) {
        this.productMin.set(min);
    }
    /**
     * Getter for the min
     * @return the min of the product
     */
    public int getMin() {
        return this.productMin.get();
    }

    public IntegerProperty productMinProperty() {
        return productMin;
    }

    /**
     * Setter for the max
     * @param max The maximum level of the product
     */
     public void setMax(int max) {
        this.productMax.set(max);
    }
    /**
     * Getter for max
     * @return the max of the product
     */
    public int getMax() {
        return this.productMax.get();
    }
    
    public IntegerProperty productMaxProperty() {
        return productMax;
    }

    /**
     * Setter for the associated parts list for the product
     * @param associatedParts The part to add
     */
    public void setAssociatedParts(ArrayList<Part> associatedParts) {
        this.associatedParts = associatedParts;
    }
    
    public ArrayList<Part> getAssociatedParts() {
        return this.associatedParts;
    }

    /**
     * Removes a part from the associated parts list for the product.
     * @return removed part
     */
    public boolean removeAssociatedPart() {
        return false;
    }
    /**
     * Gets list of associated parts for the product
     * @return a list of parts
     */
    public ObservableList<Part> getObservableAssociatedParts() {
        ObservableList<Part> parts = FXCollections.observableArrayList(this.associatedParts);
        return parts;
    }

    
   
    
    
    

   
    
}
