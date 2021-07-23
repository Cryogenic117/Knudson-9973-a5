package ucf.assignments;

import javafx.collections.ObservableList;

public class VerifyEntry {
    public static int verifySerialNumber(ObservableList<InventoryItem> list, String serial) {
        // Returns 1 if number isn't 10 character
        if (serial.length() != 10) {
            return 1;
        }
        // returns 2 if serial number isn't original
        for (InventoryItem i : list) {
            if (i.getSerialNum().compareTo(serial) == 0) {
                return 2;
            }
        }
        //returns 0 if there are no errors
        return 0;
    }

    public static int verifyValue(String value) {
        // Returns 1 if field is blank
        if (value.isEmpty()) {
            return 1;
        // Returns 2 if format is Invalid and can't be parsed
        } else try {
            @SuppressWarnings("unused") float f = Float.parseFloat(value);
        } catch (Exception e) {
            return 2;
        }
        return 0;
    }

    public static int verifyName(String name) {
        // Returns 1 if Field is blank
        if(name.isEmpty()) {

            return 1;
        }
        // Returns 0 if Entry is Correct
        if(name.length() >= 2 && name.length() <= 256) {
            return 0;
        }
        // Returns 2 if the character amount is wrong
        return 2;
    }
}
