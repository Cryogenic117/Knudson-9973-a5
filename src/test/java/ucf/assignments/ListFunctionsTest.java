/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Brandon Knudson
 */
package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ListFunctionsTest {
    // Can store over 100 inventory Items
    @Test
    public void TestStorageCapacityAddItemAbility() {

        ObservableList<InventoryItem> list = FXCollections.observableArrayList();

        for (int i = 0; i < 500; i++) {
            ListFunctions.addItem("test", "test", "test", list);
        }

        assertEquals(500, list.size());

    }

    @Test
    public void TestValueEntryChecker() {
        String value = "";
        int returnVal = -1;
        // Returns 1 if field is blank
        if (value.isEmpty()) {
            returnVal = 1;
            // Returns 2 if format is Invalid and can't be parsed
        } else try {
            @SuppressWarnings("unused") float f = Float.parseFloat(value);
        } catch (Exception e) {
            returnVal = 2;

        }
        if (returnVal == -1) {
            returnVal = 0;
        }
        assertEquals(1, returnVal);

        returnVal = -1;
        value = "abc";
        // Returns 1 if field is blank
        if (value.isEmpty()) {
            returnVal = 1;
            // Returns 2 if format is Invalid and can't be parsed
        } else try {
            @SuppressWarnings("unused") float f = Float.parseFloat(value);
        } catch (Exception e) {
            returnVal = 2;

        }
        if (returnVal == -1) {
            returnVal = 0;
        }
        assertEquals(2, returnVal);

        returnVal = -1;
        value = "123";
        // Returns 1 if field is blank
        if (value.isEmpty()) {
            returnVal = 1;
            // Returns 2 if format is Invalid and can't be parsed
        } else try {
            @SuppressWarnings("unused") float f = Float.parseFloat(value);
        } catch (Exception e) {
            returnVal = 2;

        }
        if (returnVal == -1) {
            returnVal = 0;
        }
        assertEquals(0, returnVal);
    }

    @Test
    public void VerifySerialNumberEntryTestExistingError() {
        ObservableList<InventoryItem> list = FXCollections.observableArrayList();
        ListFunctions.addItem("test", "123asd123a", "test", list);
        String serial = "123asd123a";
        assertEquals(2,SerialVerifyTest(serial, list));

    }
    @Test
    public void VerifySerialNumberEntryTestCorrect() {
        ObservableList<InventoryItem> list = FXCollections.observableArrayList();
        ListFunctions.addItem("test", "123asd123a", "test", list);
        String serial = "123asd123b";
        assertEquals(0,SerialVerifyTest(serial, list));

    }
    @Test
    public void VerifySerialNumberEntryTestTooLong() {
        ObservableList<InventoryItem> list = FXCollections.observableArrayList();
        ListFunctions.addItem("test", "123asd123a", "test", list);
        String serial = "123asd123b12";
        assertEquals(1,SerialVerifyTest(serial, list));

    }
    public int SerialVerifyTest(String serial, ObservableList<InventoryItem> list) {
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
        @Test
        public void verifyNameLengthTest(){
            assertEquals(2,verifyName("123112312312312312312312312312312312312312312312312312312312312312312312312312312312312312312312312312312312312312312312312312312312312312312312312312312312312312323123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123"));
        }
    private static int verifyName(String name) {
        // Returns 1 if Field is blank
        if (name.isEmpty()) {

            return 1;
        }
        // Returns 0 if Entry is Correct
        if (name.length() >= 2 && name.length() <= 256) {
            return 0;
        }
        // Returns 2 if the character amount is wrong
        return 2;
    }
    @Test
    public void TestRemove() {
        ObservableList<InventoryItem> list = FXCollections.observableArrayList();
        ListFunctions.addItem("test", "test", "test", list);
        ListFunctions.removeItem(list.get(0),list);
        assertTrue(list.isEmpty());
    }
    @Test
    public void Search() {
        ObservableList<InventoryItem> list = FXCollections.observableArrayList();
        ListFunctions.addItem("test", "123456789", "test", list);
        ObservableList<InventoryItem> searchList =ListFunctions.search("123456789", list);
        assertEquals(list, searchList);
    }
}
