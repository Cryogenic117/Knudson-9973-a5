package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class Functions {
    public static void displayList(ObservableList<InventoryItem> list, TableView<InventoryItem> tableView) {
        tableView.setItems(list);
    }

    public static ObservableList<InventoryItem> addItem(String name, String serial, String value, ObservableList<InventoryItem> list) {
        list.add(new InventoryItem(serial, name, value));

        return list;
    }
    public static ObservableList<InventoryItem> removeItem(ObservableList<InventoryItem> selected, ObservableList<InventoryItem> list) {
        for(InventoryItem item : selected) {
            list.remove(item);
        }

            return list;
    }

    public static ObservableList<InventoryItem> search(String key, ObservableList<InventoryItem> list) {
        ObservableList<InventoryItem> results = FXCollections.observableArrayList();

        for (InventoryItem inventoryItem : list) {
            if (inventoryItem.getName().toLowerCase().compareTo(key) == 0) {
                results.add(inventoryItem);
            } else if (inventoryItem.getSerialNum().toLowerCase().compareTo(key) == 0) {
                results.add(inventoryItem);
            }
        }
        return results;
    }
}
