package main.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import main.main.main;
import main.model.InhousePart;
import main.model.Inventory;
import static main.model.Inventory.deletePart;
import main.model.Part;
import static main.model.Inventory.getAllParts;
import static main.model.Inventory.getPartIDCount;
import static main.model.Inventory.getProducts;
import static main.model.Inventory.lookupPart;
import main.model.OutsourcedPart;
import main.model.Product;
import static main.model.Inventory.removeProduct;

/**
 * RUNTIME ERROR
 * A runtime error occurs if a product is not selected when using the modify button, this is corrected in the productsModifyHandler.
 *
 * @author Colby Enbody
 */

public class MainScreenController {

    @FXML 
    private TextField searchPartsField;
    @FXML 
    private TextField searchProductsField;       
    @FXML
    private TableView<Part> partsTableView;  
    @FXML
    private TableColumn<Part, Integer> partsIDColumn;  
    @FXML
    private TableColumn<Part, String> partsNameColumn;  
    @FXML
    private TableColumn<Part, Integer> partsInStockColumn;  
    @FXML
    private TableColumn<Part, Double> partsPriceColumn;
    @FXML
    private TableView<Product> productsTableView;  
    @FXML
    private TableColumn<Product, Integer> productsIDColumn;  
    @FXML
    private TableColumn<Product, String> productsNameColumn;  
    @FXML
    private TableColumn<Product, Integer> productsInStockColumn;  
    @FXML
    private TableColumn<Product, Double> productsPriceColumn;
    @FXML
    public ObservableList<Part> tempPart=FXCollections.observableArrayList();
    public ObservableList<Product> tempProduct=FXCollections.observableArrayList();
    private Part newPart;
    private Product newProduct;
    private main main;
    private static int index;

    public MainScreenController() {
        
    }

    /**
     *method to be able to grab selected part or product index from other controllers
     */
    public static int modifyIndex() {
        return index;
    }
           
    @FXML
    void exitHandler(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initModality(Modality.NONE);
        alert.setTitle("Confirm Exit");
        alert.setHeaderText("Please confirm you want to exit.");
        alert.setContentText("Any unsaved changes will be lost.");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            System.exit(0);
        }
        else {
            System.out.println("You clicked cancel.");
        }
    }
    /**
     *
     * @param event Add button action.
     * @throws IOException
     */
    @FXML
    void partsAddHandler(ActionEvent event) throws IOException{
        boolean okClicked = main.showPartScreen();
    }


    /**
     * Deletes the part selected by the user
     * The method displays an error message if no part is selected and a confirmation dialog before deleting the selected part
     * @param event part delete button action
     */
    @FXML
    void partsDeleteHandler(ActionEvent event) {
        Part part = partsTableView.getSelectionModel().getSelectedItem();
        if (part != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm Deletion");
            alert.setHeaderText("Are you sure you want to delete " + part.getName() + "?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                deletePart(part);
            } else {
                alert.close();
            }
        }
    }

    /**
     * The method displays an error message if no part is selected
     * @param event Part modify button action
     */
    @FXML
    void partsModifyHandler(ActionEvent event) {
        Part selectedPart = partsTableView.getSelectionModel().getSelectedItem();
        index = getAllParts().indexOf(selectedPart);
        if (selectedPart != null) {
            boolean saveClicked = main.showModifyPartScreen(selectedPart);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText("No part selected");
            alert.setContentText("Please select a part in the Table");
            alert.showAndWait();
        }
    }
    /**
     * Searches based on value in parts search text field and refreshes the parts table view with search results
     * Parts searched for by name or ID
     * @param event part search button action
     */
    @FXML
    void partsSearchHandler(ActionEvent event) {
        String searchItem=searchPartsField.getText();
        if (searchItem.equals("")){
                partsTableView.setItems(getAllParts());
        } else{
            boolean found=false;
            try{
                int itemNumber=Integer.parseInt(searchItem);
                Part p = Inventory.lookupPart(itemNumber);
                if(p != null){
                    found=true;
                    tempPart.clear();
                    tempPart.add(p);
                    partsTableView.setItems(tempPart);
                } 
                if (found==false){
                partsTableView.setItems(getAllParts());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Part Not Found");
                alert.setContentText("Please search by exact name or ID");

                alert.showAndWait();
            }
        }
        catch(NumberFormatException e){
            for(Part p: Inventory.getAllParts()){
                if(p.getName().equals(searchItem)){
                    System.out.println("This is part "+p.getPartID());
                    found=true;
                    tempPart.clear();
                    tempPart.add(p);
                    partsTableView.setItems(tempPart);
                }
            
            }
            if (found==false){
            partsTableView.setItems(getAllParts());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Part Not Found");
            alert.setContentText("Please search by exact name or ID #");
            
            alert.showAndWait();
            }
        }
        }
    
    }
    /**
     * @param event Add product button action
     */
    @FXML
    void productsAddHandler(ActionEvent event) {
        boolean okClicked = main.showProductScreen();
    }

    /**
     * Deletes the product selected by the user in the product table
     * @param event product delete button
     */

    @FXML
    void productsDeleteHandler(ActionEvent event) {

        Product product = productsTableView.getSelectionModel().getSelectedItem();

        if (product != null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Confirm Deletion of Product");
            alert.setHeaderText("Are you sure you want to delete " + product.getName() + "?");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK) {

                ObservableList<Part> assocParts = product.getObservableAssociatedParts();

                if (assocParts.size() >= 1) {
                    Alert alert2 = new Alert(Alert.AlertType.WARNING);
                    alert2.setTitle("Error");
                    alert2.setHeaderText("Parts associated to product");
                    alert2.setContentText("Please remove all parts before deletion");
                    alert2.showAndWait();
                }

             else {
                    removeProduct(product);
                }
            }
        }

    }

    /**
     * The method displays an error message if no product is selected
     * @param event product modify button action
     */
    @FXML
    void productsModifyHandler(ActionEvent event) {
        Product selectedProduct = productsTableView.getSelectionModel().getSelectedItem();
        index = getProducts().indexOf(selectedProduct);
        if (selectedProduct != null) {
            boolean okClicked = main.showModifyProductScreen(selectedProduct);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText("No product selected");
            alert.setContentText("Please select a product in the Table");
            alert.showAndWait();
        }
    }
    /**
     * Searches based on value in products search text field and refreshes the products table view with the results
     * Products can be searched by name or ID
     * @param event Part search button action
     */
    @FXML
    void productsSearchHandler(ActionEvent event) {
        String searchItem=searchProductsField.getText();
        if (searchItem.equals("")){
                productsTableView.setItems(getProducts());
        } else {
            boolean found=false;
            try{
                int itemNumber=Integer.parseInt(searchItem);
                Product p = Inventory.lookupProduct(itemNumber);
                if(p != null){
                    found=true;
                    tempProduct.clear();
                    tempProduct.add(p);
                    productsTableView.setItems(tempProduct);
                }
                if (found==false){
                    productsTableView.setItems(getProducts());
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setHeaderText("Product not found");
                    alert.setContentText("Please search by exact Product Name or ID #");
                    alert.showAndWait();
                }
                }
            catch(NumberFormatException e){
                for(Product p: Inventory.getProducts()){
                    if(p.getName().equals(searchItem)){
                        found=true;
                        tempProduct.clear();
                        tempProduct.add(p);
                        productsTableView.setItems(tempProduct);
                    }
            
                }   
                if (found==false){
                    productsTableView.setItems(getProducts());
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setHeaderText("Product not found");
                    alert.setContentText("Please search by ProductID or exact Product Name");
                    alert.showAndWait();
                }
            }
        }   
    }

    /**
     *
     * default data
     */
    void existingParts() {
        int partID = Inventory.getPartIDCount();
        InhousePart camPart1 = new InhousePart(partID, "RAM", 79.99, 30, 0, 50, 7777);
            Inventory.addPart(camPart1);
        OutsourcedPart camPart2 = new OutsourcedPart(getPartIDCount(), "CPU", 149.99, 20, 0, 50, "AMD");
            Inventory.addPart(camPart2);
        OutsourcedPart camPart3 = new OutsourcedPart(getPartIDCount(), "GPU", 199.99, 15, 0, 50, "AMD");
            Inventory.addPart(camPart3);
    }

    void existingProducts() {
        int productID = Inventory.getProductIDCount();
        ArrayList<Part> sysParts1 = new ArrayList<>();
        sysParts1.add(lookupPart(1));
        Product sysProduct1 = new Product(productID, "Gaming PC", 299.99, 3, 1, 10, sysParts1);
        Inventory.addProduct(sysProduct1);

    }

    /**
     *
     */
    @FXML
    private void initialize() {
        partsIDColumn.setCellValueFactory(
                cellData -> cellData.getValue().partIDProperty().asObject());
        partsNameColumn.setCellValueFactory(
                cellData -> cellData.getValue().nameProperty());
        partsInStockColumn.setCellValueFactory(
                cellData -> cellData.getValue().inStockProperty().asObject());
        partsPriceColumn.setCellValueFactory(
                cellData -> cellData.getValue().priceProperty().asObject());
        productsIDColumn.setCellValueFactory(
                cellData -> cellData.getValue().productIDProperty().asObject());
        productsNameColumn.setCellValueFactory(
                cellData -> cellData.getValue().productNameProperty());
        productsInStockColumn.setCellValueFactory(
                cellData -> cellData.getValue().productInStockProperty().asObject());
        productsPriceColumn.setCellValueFactory(
                cellData -> cellData.getValue().productPriceProperty().asObject());
    }
    /**
     *
     */
    public void setMainApp(main main) {
        this.main = main;
        existingParts();
        existingProducts();
        partsTableView.setItems(getAllParts());
        productsTableView.setItems(getProducts());
        
    }

}
