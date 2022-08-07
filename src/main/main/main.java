/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.main;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.model.Part;
import main.model.Product;
import main.view.MainScreenController;
import main.view.PartScreenController;
import main.view.ProductScreenController;

/**
 * javadoc is located in main
 * This program implements an application for managing an inventory of parts and products
 *
 *FUTURE ENHANCEMENT
 * A feature that I would add is the ability to compare current inventory to expected inventory to make restocking simpler
 *
 * @author Colby Enbody
 *
 */

public class main extends Application {

    /***
     * The start method creates the FXML stage and loads the initial scene
     * @param primaryStage
     */
    private Stage primaryStage;
    private AnchorPane mainScreen;
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Inventory Management System");

        showMainScreen();
    }
    
    public void showMainScreen() {
        try {
            /**
             Load overview
             */
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(main.class.getResource("/main/view/MainScreen.fxml"));
            mainScreen = (AnchorPane) loader.load();   

            /**
             *Give the controller access to the main app
             * */
            MainScreenController controller = loader.getController();
            controller.setMainApp(this);
            
            /**
            *Show the scene containing the root layout
             */
            Scene scene = new Scene(mainScreen);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public boolean showPartScreen() {
    try {
        /**
         * Loads the FXML file and create a new stage for the popup dialog
         */
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(main.class.getResource("/main/view/PartScreen.fxml"));
        AnchorPane partScreen = (AnchorPane) loader.load();

        /**
         * Create the dialog Stage
         */
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Add Part");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(partScreen);
        dialogStage.setScene(scene);

        /**
         * Set the person into the controller
         */
        PartScreenController controller = loader.getController();
        controller.setDialogStage(dialogStage);

        /**
         * Show the dialog and wait until the user closes it
         */
        dialogStage.showAndWait();

        return controller.isOkClicked();
        } catch (IOException e) {
        e.printStackTrace();
        return false;
        }
    }
    
    public boolean showModifyPartScreen(Part part) {
    try {
        /**
         * Load the fxml file and create a new stage for the popup dialog
         */
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(main.class.getResource("/main/view/ModifyPartScreen.fxml"));
        AnchorPane partScreen = (AnchorPane) loader.load();

        /**
         * Create the dialog Stage
         */
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Edit Part");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(partScreen);
        dialogStage.setScene(scene);

        /**
         * Set the person into the controller
         */
        PartScreenController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setPart(part);

        /**
         * Show the dialog and wait until the user closes it
         */
        dialogStage.showAndWait();

        return controller.isOkClicked();
        } catch (IOException e) {
        e.printStackTrace();
        return false;
        }
    }
    
    public boolean showProductScreen() {
    try {
        /**
         * Load the FXML file and create a new stage for the pop-up dialog
         */
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(main.class.getResource("/main/view/ProductScreen.fxml"));
        AnchorPane partScreen = (AnchorPane) loader.load();

        /**
         * Create the dialog Stage
         */
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Add Product");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(partScreen);
        dialogStage.setScene(scene);

        /**
         * Set the person into the controller
         */
        ProductScreenController controller = loader.getController();
        controller.setDialogStage(dialogStage);

        /**
         * Show the dialog and wait until the user closes it
         */
        dialogStage.showAndWait();

        return controller.isOkClicked();
        } catch (IOException e) {
        e.printStackTrace();
        return false;
        }
    }
    
    public boolean showModifyProductScreen(Product product) {
    try {
        /**
         * Load the FXML file and create a new stage for the popup dialog
         */
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(main.class.getResource("/main/view/ModifyProductScreen.fxml"));
        AnchorPane partScreen = (AnchorPane) loader.load();
        /**
         *Create the dialog Stage
         */
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Edit Product");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(partScreen);
        dialogStage.setScene(scene);

        /**
         * Set the person into the controller
         */
        ProductScreenController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setProduct(product);

        /**
         * Show the dialog and wait until the user closes it
         */

        dialogStage.showAndWait();

        return controller.isOkClicked();
        } catch (IOException e) {
        e.printStackTrace();
        return false;
        }
    }

}

