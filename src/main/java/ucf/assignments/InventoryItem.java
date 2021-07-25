/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Brandon Knudson
 */
package ucf.assignments;

import javafx.beans.property.SimpleStringProperty;

public class InventoryItem {
    private final SimpleStringProperty serialNum;
    private final SimpleStringProperty name;
    private final SimpleStringProperty value;

    public String getSerialNum() {
        return serialNum.get();
    }

    public void setSerialNum(String serialNum) {
        this.serialNum.set(serialNum);
    }

    public String getName() {
        return name.get();
    }

    public String getValue() {
        return value.get();
    }

    public void setValue(String value) {
        this.value.set(value);
    }

    public InventoryItem(String serialNum, String name, String value) {
        this.serialNum = new SimpleStringProperty(serialNum);
        this.name = new SimpleStringProperty(name);
        this.value = new SimpleStringProperty(value);
    }
    public String getTSVFormat() {
        return getName() +"\t" + getSerialNum() + "\t" + getValue() + "\n";
    }

    public String getHTMLFormat() {
        return "\t<tr>\n" + "\t\t<td>" + getName() + "</td>\n" + "\t\t<td>" + getSerialNum() + "</td>\n" + "\t\t<td>" + getValue() + "</td>\n" + "\t</tr>\n";
    }
    public String getJSONFormat() {
        return "{ \"name\" : \"" + getName() + "\", \"serial\": \"" + getSerialNum() + "\", \"value\" :" + "\""+getValue() + "\"" + "}";
    }
}