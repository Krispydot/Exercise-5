import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
        public void start() {
            Scanner scanner = new Scanner(System.in);
            int userInput;
            int action;
            Roles chosenRole = null;
            System.out.println("Welcome! To start playing choose a role:");
            System.out.println("1 - Warrior, 2 - Mage, 3 - Archer");
            userInput = scanner.nextInt();
            chosenRole = chooseRole(userInput, chosenRole);
            Player player = createPlayer(chosenRole);
            Enemy enemy = createEnemies();
            split();
            System.out.println("A wild " + enemy.getName() + " appeared!");
            System.out.println("Health: " + enemy.getHealth());
            System.out.println("Damage: " + enemy.getDamage());
            while(player.getHealth() > 0 && enemy.getHealth() > 0) {
                split();
                System.out.println("Your turn!");
                System.out.println("1. Attack");
                System.out.println("2. Use Item");
                System.out.println("3. Run");
                action = scanner.nextInt();
                if (action == 1) {
                    System.out.println("You attack the " + enemy.getName() + "!");
                    crit(player, enemy);
                    System.out.println(enemy.getName() + " health: " + enemy.getHealth());
                } else if (action == 3) {
                    System.out.println("You ran away...");
                    break;
                } else if (action == 2) {
                    System.out.println("You used the " + chosenRole.getItem() + "!");
                    Item item = chosenRole.getItem();
                    useItem(item, player, enemy);

                }
                if (died(enemy, player)) break;
                split();
                enemyTurn(enemy, player);
            }


        }


    private static void useItem(Item item, Player player, Enemy enemy) {
        switch (item.getType()) {
            case HEAL:
                player.heal(item.getValue());
                System.out.println("You have been healed for " + item.getValue() + " health!");
                System.out.println("Your health: " + player.getHealth());
                break;
            case DAMAGE:
                enemy.takeDamage(item.getValue());
                System.out.println("You have damaged the " + enemy.getName() + " for " + item.getValue() + " damage!");
                System.out.println(enemy.getName() + " health: " + enemy.getHealth());
                break;
            case POISON:
                enemy.takeDamage(item.getValue());
                System.out.println("You have poisoned the " + enemy.getName() + "!");
                System.out.println(enemy.getName() + " got poisoned for " + item.getValue() + " damage!");
                System.out.println(enemy.getName() + " health: " + enemy.getHealth());
                break;
        }
    }
    private static void crit(Player player, Enemy enemy) {
            int crit = (int) (Math.random() * 2);
            int damage = player.getDamage();
           if (crit == 0) {
               damage *= 2;
               System.out.println("CRITICAL HIT!");
           }
            enemy.takeDamage(damage);
    }

    private static void enemyTurn(Enemy enemy, Player player) {
        System.out.println("Enemy's turn!");
        System.out.println(enemy.getName() + " attacks for " + enemy.getDamage() + " damage!");
        player.takeDamage(enemy.getDamage());
        System.out.println("Your health: " + player.getHealth());
    }

    private static boolean died(Enemy enemy, Player player) {
        if (enemy.getHealth() <= 0) {
            System.out.println("You defeated the " + enemy.getName() + "!");
            return true;
        } if (player.getHealth() <= 0) {
            System.out.println("GAME OVER! YOU DIED.");
            return true;
        }
        return false;
    }

    private static Enemy createEnemies() {
        Enemy skeleton = new Enemy.Builder()
                .name("Skeleton")
                .damage(30)
                .health(70)
                .build();
        Enemy demon = new Enemy.Builder()
                .name("Demon")
                .health(100)
                .damage(15)
                .build();
        Enemy ghost = new Enemy.Builder()
                .name("Ghost")
                .health(75)
                .damage(30)
                .build();
        Enemy orc = new Enemy.Builder()
                .name("Orc")
                .health(120)
                .damage(25)
                .build();
        List<Enemy> enemies = List.of(skeleton, demon, ghost, orc);
        Random random = new Random();
        Enemy enemy = enemies.get(random.nextInt(enemies.size()));
        return enemy;
    }

    private static Player createPlayer(Roles chosenRole) {
        Player player = new Player.Builder()
                .name(chosenRole)
                .damage(chosenRole.getDamage())
                .health(chosenRole.getHealth())
                .inventory(chosenRole.getItem())
                .build();
        System.out.println("You are a " + chosenRole);
        System.out.println("Health: " + chosenRole.getHealth());
        System.out.println("Damage: " + chosenRole.getDamage());
        System.out.println("Inventory: " + chosenRole.getItem());
        return player;
    }

    private static Roles chooseRole(int userInput, Roles chosenRole) {
        switch (userInput) {
            case 1: chosenRole = Roles.WARRIOR; break;
            case 2: chosenRole = Roles.MAGE; break;
            case 3: chosenRole = Roles.ARCHER; break;
            default: System.out.println("ERROR: Wrong input!");
        }
        return chosenRole;
    }

    public static void split() {
        System.out.println("---------------");
    }
        }
