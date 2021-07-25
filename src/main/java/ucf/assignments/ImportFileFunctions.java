/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Brandon Knudson
 */
package ucf.assignments;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import ucf.assignments.controllers.InventorySystemController;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ImportFileFunctions {
    public static void inputHandler(Label errorReporter, TextField filePathField, ChoiceBox choiceBox) {
        if (filePathField.getCharacters().toString().isEmpty()) {
            errorReporter.setText("Please Include a File path");
            return;
        }
        String file = choiceBox.getValue().toString();

        if (file.equals("TSV")) {
            ImportTSV(errorReporter, filePathField);
        } else if (file.equals("HTML")) {
            importHtml(errorReporter, filePathField);
        } else {
            importAsJSON(errorReporter, filePathField);
        }
    }

    private static void importAsJSON(Label errorReporter, TextField filePathField) {
        String path = filePathField.getCharacters().toString();

        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(path));

            JSONObject jsonObject = (JSONObject) obj;

            JSONArray items = (JSONArray) jsonObject.get("items");

            for (Object item : items) {
                String line = item.toString();
                String[] data = line.split(",");

                String serial = data[0].substring(11, data[0].length() - 1);
                String name = data[1].substring(8, data[1].length() - 1);
                String value = data[2].substring(9, data[2].length() - 2);

                ListFunctions.addItem(name, serial, value, InventorySystemController.getList());
                App.closePopUp();
            }

        } catch (IOException e) {
            errorReporter.setText("Error: Invalid FIle Path");
            e.printStackTrace();
        } catch (ParseException e) {
            errorReporter.setText("Error: Invalid file");
            e.printStackTrace();
        }

    }

    private static void importHtml(Label errorReporter, TextField filePathField) {
        String path = filePathField.getCharacters().toString();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            errorReporter.setText("File Location Not Found");
            e.printStackTrace();
        }


        try {
            assert reader != null;
            reader.readLine();
            reader.readLine();
            reader.readLine();
            reader.readLine();
            reader.readLine();
            reader.readLine();

            while (reader.readLine() != null) {
                String line1 = reader.readLine();
                String line2 = reader.readLine();
                String line3 = reader.readLine();
                reader.readLine();
                if(line1 == null) {
                    errorReporter.setText("Invalid File Type");
                    return;
                }
                String name = line1.substring(6, line1.length()-5);
                String serial = line2.substring(6, line2.length()-5);
                String value = line3.substring(6, line3.length()-5);

                ListFunctions.addItem(name, serial, value, InventorySystemController.getList());
            }
            reader.close();
            App.closePopUp();
        } catch (Exception e) {
            errorReporter.setText("Error Reading file");
        }
    }

    private static void ImportTSV(Label errorReporter, TextField filePathField) {
        String path = filePathField.getCharacters().toString();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            errorReporter.setText("File Location Not Found");
            e.printStackTrace();
        }

        try {
            String line;
            assert reader != null;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\t");
                ListFunctions.addItem(data[0], data[1], data[2], InventorySystemController.getList());
            }
            reader.close();
            App.closePopUp();
        } catch (Exception e) {
            errorReporter.setText("Error Reading File");
            e.printStackTrace();
        }

    }
}
