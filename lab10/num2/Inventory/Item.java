package lab10.num2.Inventory;

public interface Item {
    public int MIN_VALUE = 1;
    public int MAX_VALUE = 10;

    public int use();
    public boolean isUsed();
}
