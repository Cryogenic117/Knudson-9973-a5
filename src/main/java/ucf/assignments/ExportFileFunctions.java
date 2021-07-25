package ucf.assignments;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
            //exportAsTSV(errorReporter, filePathField, name);
        } else if (file.equals("HTML")) {
            //exportAsHtml(errorReporter, filePathField, name);
        }
        else {
            //exportAsJSON(errorReporter, filePathField, name);
        }
    }
}
