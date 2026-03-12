import java.util.Scanner;

public class Game {
    public void game() {
        Scanner scanner = new Scanner(System.in);
        int userInput;
        Roles chosenRole = null;
        System.out.println("Welcome! To start playing choose a role:");
        System.out.println("1 - Warrior, 2 - Mage, 3 - Archer");
        userInput = scanner.nextInt();
        switch (userInput) {
            case 1: chosenRole = Roles.WARRIOR; break;
            case 2: chosenRole = Roles.MAGE; break;
            case 3: chosenRole = Roles.ARCHER; break;
            default: System.out.println("ERROR: Wrong input!");
        }
        Player player = new Player.Builder()
                .name(chosenRole)
                .damage(chosenRole.getDamage())
                .health(chosenRole.getHealth())
                .build();
        System.out.println("You are a " + chosenRole);
        System.out.println("Health: " + chosenRole.getHealth());
        System.out.println("Damage: " + chosenRole.getDamage());

    }

    }
