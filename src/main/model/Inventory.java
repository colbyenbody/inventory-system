
package main.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Models an inventory of Parts and Products
 *
 * @author Colby Enbody
 */

public class Inventory {

    /**
     * A list of products in inventory
     */
    private static ObservableList<Product> products = FXCollections.observableArrayList();

    /**
     * A list of parts in inventory
     */
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();

    /**
     * An ID for a part
     */
    private static int partIDCount = 0;

    /**
     * An ID for a product
     */
    private static int productIDCount = 0;
    public static boolean alreadyExecuted = false;

    /**
     * Gets a list of parts in inventory
     * @return A list of parts
     */
    public static ObservableList<Part> getAllParts() {
        return allParts;
    }

    /**
     * Adds a part to the inventory
     * @param part part object to add
     */
    public static void addPart(Part part) {
        allParts.add(part);
    }

    /**
     * Removes a part from the list of parts
     * @param part The part to be removed
     */
    public static void deletePart(Part part) {
        allParts.remove(part);
    }

    /**
     * Replaces a part in the list of parts
     * @param index Index of the part to be updated
     * @param part The part used for replacement
     */
    public static void updatePart(int index, Part part) {
        allParts.set(index, part);
    }

    public static int getPartIDCount() {
        partIDCount++;
        return partIDCount;
    }
    
    public static int cancelPartIDCount() {
        partIDCount--;
        return partIDCount;
    }

    /**
     * Searches the list of products by ID.
     *
     * @param itemNumber part to look up
     * @return The part object if found, null if not found
     */
    public static Part lookupPart(int itemNumber) {
        for(Part p: getAllParts()){
            if(p.getPartID()==itemNumber){
                return p;                
            }
       }
       return null;
    }


    /**
     * Gets a list of products in inventory
     * @return A list of products
     */
    public static ObservableList<Product> getProducts() {
        return products;
    }

    /**
     * Adds a part to the inventory.
     * @param product part object to add
     */
    public static void addProduct(Product product) {
        products.add(product);
    }

    /**
     * Removes a product from the list of parts.
     * @param product The part to be removed
     */
    public static void removeProduct(Product product) {
        products.remove(product);
    }

    public static int getProductIDCount() {
        productIDCount++;
        return productIDCount;
    }
    
   
    public static int cancelProductIDCount() {
        productIDCount--;
        return productIDCount;
    }
    /**
     * Searches the list of products by name
     * @param itemNumber The product name
     * @return list of products
     */
    public static Product lookupProduct(int itemNumber) {
        for(Product p: getProducts()){
            if(p.getProductID()==itemNumber){
                return p;                
            }
       }
       return null;
    }
    /**
     * Replaces a part in the list of products
     * @param index Index of the product to be updated
     * @param product The product used for replacement
     */
    public static void updateProduct(int index, Product product) {
        products.set(index, product);
    }
}
