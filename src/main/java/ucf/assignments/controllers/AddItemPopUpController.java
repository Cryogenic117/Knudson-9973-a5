/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Brandon Knudson
 */
package ucf.assignments.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ucf.assignments.App;
import ucf.assignments.ListFunctions;
import ucf.assignments.VerifyItemEntry;

public class AddItemPopUpController {
    @FXML
    public TextField serialNumField, valueField, nameField;
    @FXML
    public Label errorReporter;

    @FXML
    public void okButtonClicked() {
        String name = nameField.getCharacters().toString();
        String serial = serialNumField.getCharacters().toString();
        String value = valueField.getCharacters().toString();
        if(VerifyItemEntry. validateEntries(errorReporter,name, value, serial, InventorySystemController.getList())) {
            value = String.format("$%.2f", Float.parseFloat(valueField.getCharacters().toString()));
            ListFunctions.addItem(name, serial, value, InventorySystemController.getList());

            App.closePopUp();
        }
    }

    @FXML
    public void cancelButtonClicked() {
        App.closePopUp();
    }
}
