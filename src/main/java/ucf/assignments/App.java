/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 first_name last_name
 */
package ucf.assignments;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class App extends Application {
    private static Stage mainStage, popUpStage;

    public static void main(String[] args) {
        launch(args);
    }

    public static void addItemPopUp() {
        try {
            URL url = App.class.getClassLoader().getResource("AddItemPopUp.fxml");
            FXMLLoader loader = new FXMLLoader(url);
            Parent root = loader.load();
            Scene scene = new Scene(root);

            popUpStage = new Stage();
            popUpStage.setTitle("Add Inventory Item");
            popUpStage.setScene(scene);

            popUpStage.initOwner(mainStage);
            popUpStage.initModality(Modality.APPLICATION_MODAL);
            popUpStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  static void openFilePopUp() {
        try {
            URL url = App.class.getClassLoader().getResource("ImportPopUp.fxml");
            FXMLLoader loader = new FXMLLoader(url);
            Parent root = loader.load();
            Scene scene = new Scene(root);

            popUpStage = new Stage();
            popUpStage.setTitle("Import Inventory Items");
            popUpStage.setScene(scene);

            popUpStage.initOwner(mainStage);
            popUpStage.initModality(Modality.APPLICATION_MODAL);
            popUpStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void savePopUp() {
        try {
            URL url = App.class.getClassLoader().getResource("ExportPopUp.fxml");
            FXMLLoader loader = new FXMLLoader(url);
            Parent root = loader.load();
            Scene scene = new Scene(root);

            popUpStage = new Stage();
            popUpStage.setTitle("Export Inventory Items");
            popUpStage.setScene(scene);

            popUpStage.initOwner(mainStage);
            popUpStage.initModality(Modality.APPLICATION_MODAL);
            popUpStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void closePopUp() {
        popUpStage.close();
    }

    @Override
    public void start(Stage stage) {
        try {
            mainStage = stage;

            URL url = getClass().getClassLoader().getResource("application.fxml");
            FXMLLoader loader = new FXMLLoader(url);
            Parent root = loader.load();

            Scene scene = new Scene(root);
            mainStage.setTitle("Inventory Manager");
            mainStage.setScene(scene);

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}