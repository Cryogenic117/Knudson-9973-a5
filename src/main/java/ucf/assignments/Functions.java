package ucf.assignments;

import javafx.collections.ObservableList;

public class Functions {
    public static void openNewItem() {
        App.addItemPopUp();
    }
    public static ObservableList<InventoryItem> addItem(String name, String serial, String value, ObservableList<InventoryItem> list) {
        InventorySystemController.list.add(new InventoryItem(serial, name, value));

        return list;
    }
    public static ObservableList<InventoryItem> removeItem(ObservableList<InventoryItem> selected, ObservableList<InventoryItem> list) {
        for(InventoryItem item : selected) {
            list.remove(item);
        }

            return list;
    }
}
