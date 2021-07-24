package ucf.assignments.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import ucf.assignments.App;
import ucf.assignments.Functions;
import ucf.assignments.InventoryItem;
import ucf.assignments.VerifyEntry;

@SuppressWarnings("rawtypes")
public class InventorySystemController{

    private static ObservableList<InventoryItem> list = FXCollections.observableArrayList();
    // Table Initializers
    @FXML
    private TableView<InventoryItem> tableView;
    @FXML
    private TableColumn<InventoryItem, String> nameColumn;
    @FXML
    private TableColumn<InventoryItem, String> serialNumColumn;
    @FXML
    private TableColumn<InventoryItem, String> valueColumn;
    @FXML
    private Label errorReporter;
    @FXML
    private TextField searchBar;


    public void initialize() {
        initializeTable();
    }

    @FXML
    private void initializeTable() {
        // sets up table columns
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        serialNumColumn.setCellValueFactory(new PropertyValueFactory<>("serialNum"));
        valueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));

        tableView.setItems(list);

        //allow fields to be edited
        tableView.setEditable(true);
        valueColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        serialNumColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        tableView.refresh();

    }
    @FXML
    public void changeSerialNumEvent(TableColumn.CellEditEvent cell) {
        InventoryItem itemSelected = tableView.getSelectionModel().getSelectedItem();
        // Add check on all change item events
        if(VerifyEntry.verifySerialNumber(list , cell.getNewValue().toString(), errorReporter) == 0) {
            itemSelected.setSerialNum(cell.getNewValue().toString());
            errorReporter.setText("");
        }
        tableView.refresh();
    }
    @FXML
    public void changeValueEvent(TableColumn.CellEditEvent cell) {
        InventoryItem itemSelected = tableView.getSelectionModel().getSelectedItem();
        if(VerifyEntry.verifyValue(cell.getNewValue().toString(), errorReporter) == 0) {
            errorReporter.setText("");
            itemSelected.setValue(cell.getNewValue().toString());
        }
        tableView.refresh();
    }
    @FXML
    public void changeNameEvent(TableColumn.CellEditEvent cell) {
        InventoryItem itemSelected = tableView.getSelectionModel().getSelectedItem();
        if(VerifyEntry.verifyName(cell.getNewValue().toString(), errorReporter) == 0) {
            errorReporter.setText("");
            itemSelected.setValue(cell.getNewValue().toString());
        }
        tableView.refresh();
    }
    // Buttons
    @FXML
    public void saveButtonClicked() {

    }
    @FXML
    public void openButtonClicked() {

    }
    @FXML
    public void NewButtonClicked() {
        App.addItemPopUp();
    }
    @FXML
    public void removeButtonClicked() {
        if(tableView.getSelectionModel().getSelectedItems().size() == 0) {
            errorReporter.setText("Please select an Item to Delete");
            return;
        }
        errorReporter.setText("");
        Functions.removeItem(tableView.getSelectionModel().getSelectedItems(), list);
    }

    public void searchButtonClicked() {
        String key = searchBar.getText().toLowerCase();
        ObservableList<InventoryItem> results;
        results = Functions.search(key, list);
        if(results.size() == 0) {
            Functions.displayList(list, tableView);
            errorReporter.setText("No Results Found");
        }
        else {
            Functions.displayList(results, tableView);
        }

    }
    public static ObservableList<InventoryItem> getList() {
        return list;
    }
}