package ucf.assignments;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
        if(VerifyEntry. validateEntries(errorReporter,name, value, serial, InventorySystemController.getList())) {
            value = String.format("$%.2f", Float.parseFloat(valueField.getCharacters().toString()));
            Functions.addItem(name, serial, value, InventorySystemController.getList());

            App.closePopUp();
        }
    }

    @FXML
    public void cancelButtonClicked() {
        App.closePopUp();
    }
}
