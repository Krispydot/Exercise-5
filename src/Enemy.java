public class Enemy {
    private Enemy(Builder builder) {
        this.name = builder.name;
        this.health = builder.health;
        this.damage = builder.damage;
    }
    private final String name;
    private final int damage;
    private final int health;

    public static class Builder {
        private String name;
        private int damage;
        private int health;

        public Builder health(int health) {
            this.health = health;
            return this;
        }

        public Builder damage(int damage) {
            this.damage = damage;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Enemy build() {
            return new Enemy(this);
        }
    }

}
