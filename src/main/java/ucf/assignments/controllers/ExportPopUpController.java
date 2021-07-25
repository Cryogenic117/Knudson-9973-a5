/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Brandon Knudson
 */
package ucf.assignments.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ucf.assignments.App;
import ucf.assignments.ExportFileFunctions;

public class ExportPopUpController {
    @FXML
    public TextField filePathField;
    @FXML
    public ChoiceBox<String> choiceBox;
    @FXML
    public TextField nameField;
    @FXML
    public Label errorReporter;
    @FXML
    ObservableList<String> fileTypeList = FXCollections.observableArrayList("TSV", "HTML", "JSON");

    @FXML
    private void initialize() {
        choiceBox.setValue("TSV");
        choiceBox.setItems(fileTypeList);
    }

    public void cancelButtonClicked() {
        App.closePopUp();
    }

    public void okayButtonClicked() {
        ExportFileFunctions.inputHandler(errorReporter, filePathField, nameField, choiceBox);
    }
}
