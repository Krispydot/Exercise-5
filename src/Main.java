//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Scanner scanner = new Scanner(System.in);
    int userInput;
    int action;
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
    Enemy skeleton = new Enemy.Builder()
            .name("Skeleton")
            .damage(20)
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
    List<Enemy> enemies = List.of(skeleton, demon, ghost);
    Random random = new Random();
    Enemy enemy = enemies.get(random.nextInt(enemies.size()));
    split();
    System.out.println("A wild " + enemy.getName() + " appeared!");
    System.out.println("Health: " + enemy.getHealth());
    System.out.println("Damage: " + enemy.getDamage());
    while(player.getHealth() > 0 && enemy.getHealth() > 0) {
        split();
        System.out.println("Your turn!");
        System.out.println("1. Attack");
        System.out.println("2. Run");
        action = scanner.nextInt();
        if (action == 1) {
            System.out.println("You attack the " + enemy.getName());
            enemy.takeDamage(player.getDamage());
        } else if (action == 2) {
            System.out.println("You ran away...");
            break;
        }
        split();
        System.out.println("Enemy's turn!");
        System.out.println(enemy.getName() + " attacks for " + enemy.getDamage() + " damage!");
        player.takeDamage(enemy.getDamage());
        System.out.println("Your health: " + player.getHealth());
        if (enemy.getHealth() <= 0) {
            split();
            System.out.println("You defeated the " + enemy.getName() + "!");
            break;
        }
    }

}
public void split() {
    System.out.println("---------------");
}
