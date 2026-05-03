package lab10.num2.Hero;

public interface Player{
    public String getUsername();
    public int damage(int damage);
    public boolean fight(Player player, int countAttacks);
}
