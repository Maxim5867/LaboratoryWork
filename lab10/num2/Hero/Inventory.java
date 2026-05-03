package lab10.num2.Hero;

import lab10.num2.Inventory.Item;

public interface Inventory{
    public int ITEMS_COUNT = 5;
    public boolean putInto(Item item, int countItem);
    public boolean useItem(int countUseItem);
}
