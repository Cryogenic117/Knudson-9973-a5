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
        if(validateEntries()) {
            String name = nameField.getCharacters().toString();
            String serial = serialNumField.getCharacters().toString();
            String value = String.format("$%.2f", Float.parseFloat(valueField.getCharacters().toString()));

            Functions.addItem(name, serial, value, InventorySystemController.list);

            App.closePopUp();
        }
    }

    @FXML
    public void cancelButtonClicked() {
        App.closePopUp();
    }

    private boolean validateEntries() {
        //Verify Name
        int result = VerifyEntry.verifyName(nameField.getCharacters().toString());
        if(result != 0) {
            switch (result) {
                case 1 -> {
                    errorReporter.setText("Error: Fields Can Not Be Blank.");
                    return false;
                }
                case 2 -> {
                    errorReporter.setText("Error: Name Must Be From 2 to 256 Characters");
                    return false;
                }
            }
        }
       // Verify Value
        result = VerifyEntry.verifyValue(valueField.getCharacters().toString());
        if(result != 0) {
            switch (result) {
                case 1 -> {
                    errorReporter.setText("Error: Fields Can Not Be Blank.");
                    return false;
                }
                case 2 -> {
                    errorReporter.setText("Error: Invalid Value Format Enter as \"00.00\".");
                    return false;
                }
            }
        }
        // Verify Serial number
        result = VerifyEntry.verifySerialNumber(InventorySystemController.list, serialNumField.getCharacters().toString());
        if (result != 0) {
            switch (result) {
                case 1 -> {
                    errorReporter.setText("Error: Serial Number Must Be 10 Characters.");
                    return false;
                }
                case 2 -> {
                    errorReporter.setText("Error: Serial Number Must Be Original.");
                    return false;
                }
            }
        }
        return true;
    }
}
