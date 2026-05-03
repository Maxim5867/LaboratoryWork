package lab10.num2.Hero;

import lab10.num2.Inventory.Food;
import lab10.num2.Inventory.HealthPotion;
import lab10.num2.Inventory.Item;
import lab10.num2.Weapon.BaseWeapon;
import lab10.num2.Weapon.Sword;
import lab10.num2.Weapon.Weapon;

import java.util.Objects;

public class Knight extends Hero{
    private int MAX_STRENGTH = 100;
    public int strength;
    private int forcePower = 1;

    public Knight(String username, int health, int strength) {
        super(username,health);
        this.strength = strength;
    }

    public boolean fight(Player player, int distance){
        if ((player == null && distance < 1) || player == this){ return false;}

        int reachableDistance = 1;
        if (weapon != null) {
            reachableDistance += weapon.getDistance();
        }

        if ((reachableDistance) < distance){
            return false;
//            throw new IllegalArgumentException(getClass().getSimpleName() + " " + getUsername() +  " can't reach enemy");
        }

        int damage = forcePower;
        if (weapon != null) {
            damage = (int) (forcePower*weapon.getPower());
        }

        if (strength >= forcePower){
            strength -= forcePower;
            player.damage(damage);
            return true;
        } else System.out.println(getClass().getSimpleName() + " " + getUsername() + " don't have strength");
        return false;
    }

    public boolean change(Weapon weapon){
        if (weapon != null) {
            this.weapon = weapon;
            return true;
        } else {
            System.out.println("You have weapon!");
            return false;
        }
    }

    public void recoverStrength(int food){
        if (!isDied()) {
            strength += food;
        }
    }

    public boolean useItem(int slot){
        if (slot >= Item.MIN_VALUE && slot <= Item.MAX_VALUE){
            Item item = items[slot - 1];
            if (item != null && !item.isUsed()){
                if (item instanceof HealthPotion){
                    recoverHealth(item.use()*5);
                }
                else if (item instanceof Food){
                    recoverStrength(item.use()*5);
                }
//                switch (item.getClass().getSimpleName()){
//                    case "HealthPotion" -> recoverHealth(item.use()*5);
//                    case "Food" -> recoverStrength(item.use()*5);
//                }
                item.isUsed();
                items[slot-1] = null;
                return true;
            } else return false;
        } else return false;
    }
}
