import java.util.ArrayList;
import java.util.List;

public enum Roles {
    ARCHER(80, 30, new Item("Poison Arrow", ItemType.POISON, 20)),
    MAGE(70, 35, new Item("Healing Potion", ItemType.HEAL, 30)),
    WARRIOR(100, 25, new Item("Bomb", ItemType.DAMAGE, 50));

    Roles(int health, int damage, Item item) {
        this.health = health;
        this.damage = damage;
        this.item = item;
    }

    private final int health;

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    private final int damage;

    public Item getItem() {
        return item;
    }

    private Item item;

}
