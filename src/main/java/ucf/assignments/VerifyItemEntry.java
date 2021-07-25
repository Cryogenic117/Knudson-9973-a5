/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Brandon Knudson
 */
package ucf.assignments;

import javafx.collections.ObservableList;
import javafx.scene.control.Label;

public class VerifyItemEntry {
    public static int verifySerialNumber(ObservableList<InventoryItem> list, String serial, Label errorReporter) {
        // Returns 1 if number isn't 10 character
        if (serial.length() != 10) {
            errorReporter.setText("Error: Serial Number Must Be 10 Characters.");
            return 1;
        }
        // returns 2 if serial number isn't original
        for (InventoryItem i : list) {
            if (i.getSerialNum().compareTo(serial) == 0) {
                errorReporter.setText("Error: Serial Number Must Be Original.");
                return 2;
            }
        }
        //returns 0 if there are no errors
        return 0;
    }

    public static int verifyValue(String value, Label errorReporter) {
        // Returns 1 if field is blank
        if (value.isEmpty()) {
            errorReporter.setText("Error: Fields Can Not Be Blank.");
            return 1;
            // Returns 2 if format is Invalid and can't be parsed
        } else try {
            @SuppressWarnings("unused") float f = Float.parseFloat(value);
        } catch (Exception e) {
            errorReporter.setText("Error: Invalid Value Format Enter as \"00.00\".");
            return 2;
        }
        return 0;
    }

    public static int verifyName(String name, Label errorReporter) {
        // Returns 1 if Field is blank
        if (name.isEmpty()) {
            errorReporter.setText("Error: Fields Can Not Be Blank.");
            return 1;
        }
        // Returns 0 if Entry is Correct
        if (name.length() >= 2 && name.length() <= 256) {
            return 0;
        }
        // Returns 2 if the character amount is wrong
        errorReporter.setText("Error: Name Must Be From 2 to 256 Characters");
        return 2;
    }

    public static boolean validateEntries(Label errorReporter, String name, String value, String serial, ObservableList<InventoryItem> list) {
        //Verify Name
        int result = VerifyItemEntry.verifyName(name, errorReporter);
        if (result != 0) {
            return false;
        }
        // Verify Value
        result = VerifyItemEntry.verifyValue(value, errorReporter);
        if (result != 0) {
            return false;
        }
        // Verify Serial number
        result = VerifyItemEntry.verifySerialNumber(list, serial, errorReporter);
        return result == 0;
    }
}
