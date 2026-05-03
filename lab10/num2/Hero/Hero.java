package lab10.num2.Hero;

import lab10.num2.Armor.Armor;
import lab10.num2.Armor.BaseArmor;
import lab10.num2.Inventory.HealthPotion;
import lab10.num2.Inventory.Item;
import lab10.num2.Weapon.Weapon;

import java.util.Arrays;

public abstract class Hero implements Player,Healthy,Equipment,Inventory{
    protected int strength;
    protected String username;
    protected int health;
    protected Weapon weapon;
    protected Armor[] clothes;
    protected Item[] items;

    public Hero(String username, int health) {
        super();
        if (username != null && !username.isEmpty()) {
            this.username = username;
        } else throw new IllegalArgumentException("Invalid username!");
        if (health < 1 || health > MAX_HEALTH){
            throw new IllegalArgumentException("Invalid count. Try again");
        }
        this.health = health;
        this.clothes = new Armor[3];
        this.items = new Item[ITEMS_COUNT];
    }

    private void loseHealth(int healthPoints){
        health -= healthPoints;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public int damage(int damage){
        if (damage >= 0) {
            for (Armor armor : clothes) {
                if (armor != null && !armor.isBroken()) {
                    damage -= armor.protect(damage);
                    if (damage <= 0) {
                        break;
                    }
                }
            }
            if (damage > 0) {
                loseHealth(damage);
            }
            return damage;
        } throw new IllegalArgumentException("Invalid damage");
    }

    public boolean isDied(){
        return health <= 0;
    }

    public void recoverHealth(int healthPoints){
        if (!isDied()) {
            if (isDied()) {
                System.out.println("Your hero died");
            } else if ( (health += healthPoints) > 100) {
                health = 100;
            }else health += healthPoints;
        }
    }

    public void dress(Armor armor){
        if (armor != null) {
            if (armor.getPosition() < 1 || armor.getPosition() > 3){
                throw new IllegalArgumentException("Invalid position");
            }
            int pos = armor.getPosition();
            clothes[pos-1] = armor;
        }
        System.out.println(username + " dress " + armor);
    }

    public boolean putInto(Item item, int slot){
        if (slot < 1 || slot > 5 || item == null || items[slot-1] != null) {
            System.out.println("Invalid slot: " + slot);
            return false;
        }
        items[slot-1] = item;
        System.out.println(username + " get " + item.getClass().getSimpleName() + " in slot " + slot);
        return true;
    }

    public abstract boolean fight(Player player, int countAttacks);

    public abstract boolean change(Weapon weapon);

    public abstract boolean useItem(int countUseItems);

    @Override
    public String toString() {
        return (getClass().getSimpleName() + ": " + username
                + ", health: " + health +
                ", weapon: " + switch (weapon) {
                    case null -> "no";
                    default -> weapon.toString(); } + ", inventory: " +
                    switch (items) {
                        case null -> "no";
                        default -> Arrays.toString(items);
                    });
    }
}
