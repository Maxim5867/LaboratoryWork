package lab10.num2.Armor;

public interface Armor {
    public int MIN_VALUE = 5;
    public int MAX_VALUE = 50;
    public boolean isBroken();
    public int protect(int durability);
    public int getPosition();
}
