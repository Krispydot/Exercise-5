public enum Roles {
    ARCHER(100, 40),
    MAGE(90, 50),
    WARRIOR(120, 30);

    Roles(int health, int damage) {
        this.health = health;
        this.damage = damage;
    }

    private final int health;

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    private final int damage;
}
