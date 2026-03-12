import java.util.ArrayList;
import java.util.List;

public class Player {

    private Player(Builder builder) {
        this.name = builder.name;
        this.health = builder.health;
        this.damage = builder.damage;
        this.inventory = builder.inventory;
    }
    private final Roles name;

    public int getDamage() {
        return damage;
    }

    public Roles getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    private int damage;
    private int health;

    public List<Item> getInventory() {
        return inventory;
    }

    private List<Item> inventory;

    public static class Builder {
        private Roles name;
        private int damage;
        private int health;
        private List<Item> inventory;

        public Builder health(int health) {
            this.health = health;
            return this;
        }

        public Builder damage(int damage) {
            this.damage = damage;
            return this;
        }

        public Builder inventory(Item inventory) {
            this.inventory = new ArrayList<>();
            return this;
        }

        public Builder name(Roles name) {
            this.name = name;
            return this;
        }

        public Player build() {
            return new Player(this);
        }
    }
    public void takeDamage(int damage) {
        health -= damage;
    }

    public void addItem(Item item) {
        inventory.add(item);
    }
}
