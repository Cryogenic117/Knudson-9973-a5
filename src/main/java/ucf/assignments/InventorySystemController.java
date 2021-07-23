package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class InventorySystemController{

    public static ObservableList<InventoryItem> list = FXCollections.observableArrayList();
    // Table Initializers
    @FXML
    private TableView<InventoryItem> tableView;
    @FXML
    private TableColumn<InventoryItem, String> nameColumn;
    @FXML
    private TableColumn<InventoryItem, String> serialNumColumn;
    @FXML
    private TableColumn<InventoryItem, String> valueColumn;


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

        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tableView.refresh();

    }

    public void changeSerialNumEvent(TableColumn.CellEditEvent cell) {
        InventoryItem itemSelected = tableView.getSelectionModel().getSelectedItem();
        itemSelected.setSerialNum(cell.getNewValue().toString());
    }
    public void changeValueEvent(TableColumn.CellEditEvent cell) {
        InventoryItem itemSelected = tableView.getSelectionModel().getSelectedItem();
        itemSelected.setValue(cell.getNewValue().toString());
    }
    // Buttons
    public void NewButtonClicked() {
        Functions.openNewItem();
    }

    public void removeButtonClicked() {
        if(tableView.getSelectionModel().getSelectedItems().size() == 0) {
            return;
        }
        Functions.removeItem(tableView.getSelectionModel().getSelectedItems(), list);
    }
}
