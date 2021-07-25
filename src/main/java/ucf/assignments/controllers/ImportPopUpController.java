package ucf.assignments.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ucf.assignments.App;
import ucf.assignments.ImportFileFunctions;

public class ImportPopUpController {
    @FXML
    public TextField filePathField;
    @FXML
    public ChoiceBox<String> choiceBox;
    @FXML
    public Label errorReporter;
    @FXML
    ObservableList<String> fileTypeList = FXCollections.observableArrayList("TSV", "HTML", "JSON");
    @FXML
    private void initialize() {
        choiceBox.setValue("TSV");
        choiceBox.setItems(fileTypeList);
    }

    public void okayButtonClicked() {
        ImportFileFunctions.inputHandler(errorReporter, filePathField, choiceBox);
    }

    public void cancelButtonClicked() {
        App.closePopUp();
    }
}
