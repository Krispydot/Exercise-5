//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Player player = new Player.Builder()
            .name(Roles.WARRIOR)
            .health(100)
            .damage(30)
            .build();
    Enemy enemy = new Enemy.Builder()
            .name("Ghost")
            .health(60)
            .damage(20)
            .build();
    
}
