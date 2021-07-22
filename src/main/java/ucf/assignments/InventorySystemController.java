package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class InventorySystemController{
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

        ObservableList<InventoryItem> list = FXCollections.observableArrayList();
        tableView.setItems(list);

        //allow fields to be edited
        tableView.setEditable(true);
        valueColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        serialNumColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        list.add(new InventoryItem("12345", "test", "2.00"));
        tableView.refresh();

    }

    // Buttons
    public void NewButtonClicked() {
        Functions.newItem();
    }
}
