public class Item {

    public Item(String name, ItemType type, int value) {
        this.name = name;
        this.type = type;
        this.value = value;
    }


    public ItemType getType() {
        return type;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return name;
    }

    private final String name;
    private final ItemType type;
    private final int value;

}
