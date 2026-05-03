package lab10.num2.Hero;

import lab10.num2.Armor.Armor;
import lab10.num2.Weapon.Weapon;

public interface Equipment{
    public int CLOTHES_COUNT = 3;
    public boolean change(Weapon weapon);
    public void dress(Armor armor);
}
