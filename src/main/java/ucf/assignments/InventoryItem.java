package ucf.assignments;

public class InventoryItem {
    String serialNum, name;
    float value;

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public InventoryItem(String serialNum, String name, float value) {
        this.serialNum = serialNum;
        this.name = name;
        this.value = value;
    }
}
