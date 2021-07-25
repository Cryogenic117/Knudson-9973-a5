package ucf.assignments;

import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ucf.assignments.controllers.InventorySystemController;

import java.io.FileWriter;
import java.io.IOException;

public class ExportFileFunctions {
    public static void inputHandler(Label errorReporter, TextField filePathField, TextField name, ChoiceBox choiceBox) {
        if (filePathField.getCharacters().toString().isEmpty()) {
            errorReporter.setText("Please Include a File path");
            return;
        } else if (name.getCharacters().toString().isEmpty()) {
            errorReporter.setText("Please Include a File Name");
            return;
        }
        String file = choiceBox.getValue().toString();

        if (file.equals("TSV")) {
            exportAsTSV(errorReporter, filePathField, name);
        } else if (file.equals("HTML")) {
            exportAsHtml(errorReporter, filePathField, name);
        }
        else {
            exportAsJSON(errorReporter, filePathField, name);
        }
    }

    private static void exportAsJSON(Label errorReporter, TextField filePathField, TextField name) {
        try {
            FileWriter writer = new FileWriter(filePathField.getCharacters().toString() + "\\" + name.getCharacters().toString() + ".json");
            ObservableList<InventoryItem> list = InventorySystemController.getList();

            writer.write("{\n");
            writer.write("\t\"items\" : [\n");
            for (int i = 0; i < list.size(); i++) {


                writer.write("\t\t"+list.get(i).getJSONFormat());
                if(i != list.size()-1) {
                    writer.write(",");
                }
                writer.write("\n");
            }
            writer.write("\t]");
            writer.write("\n}");
            writer.close();
            App.closePopUp();
        } catch (IOException e) {
            errorReporter.setText("Invalid File Path");
            e.printStackTrace();
        }

    }

    private static void exportAsHtml(Label errorReporter, TextField filePathField, TextField name) {
        try {
            FileWriter writer = new FileWriter(filePathField.getCharacters().toString() + "\\" + name.getCharacters().toString() + ".html");
            ObservableList<InventoryItem> list = InventorySystemController.getList();

            writer.write("<table style=\"width:100%\">\n");
            writer.write("\t<tr>\n");
            writer.write("\t\t<th>Name</th>\n");
            writer.write("\t\t<th>Serial Number</th>\n");
            writer.write("\t\t<th>Value</th>\n");
            writer.write("\t</tr>\n");

            for (InventoryItem inventoryItem : list) {
                writer.write(inventoryItem.getHTMLFormat());
            }
            writer.close();
            App.closePopUp();
        } catch (IOException e) {
            errorReporter.setText("Invalid File Path");
            e.printStackTrace();
        }

    }

    private static void exportAsTSV(Label errorReporter, TextField filePathField, TextField name) {
        try {
            FileWriter writer = new FileWriter(filePathField.getCharacters().toString() + "\\" + name.getCharacters().toString() + ".tsv");
            ObservableList<InventoryItem> list = InventorySystemController.getList();

            writer.write("Name\tSerial Number\t Value\n");
            for (InventoryItem inventoryItem : list) {
                writer.write(inventoryItem.getTSVFormat());
            }
            writer.close();
            App.closePopUp();
        } catch (IOException e) {
            e.printStackTrace();
            errorReporter.setText("Invalid File Path");
        }

    }
}
