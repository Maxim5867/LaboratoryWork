package lab10.num2.Hero;

import lab10.num2.Armor.*;
import lab10.num2.Inventory.Food;
import lab10.num2.Inventory.HealthPotion;
import lab10.num2.Weapon.Sword;

public class Main {
    public static void main(String[] args) {
        Knight knight1 = new Knight("Knight1", 10, 100);
        Knight knight2 = new Knight("Knight2", 100, 100);

        knight1.putInto(new HealthPotion(5), 1);
        knight1.putInto(new Food(5), 2);
        knight1.change(new Sword(5));

        knight1.useItem(1);
        knight2.dress(new Helmet(5));
        knight2.dress(new Dress(5));
        knight2.dress(new Boots(5));
        System.out.println(knight1);
        System.out.println(knight2);

        for (Armor armor : knight2.clothes) {
            System.out.println(armor);
        }
        System.out.println();

        knight1.fight(knight2, 3);
        System.out.println("*fight*");
        System.out.println();

        System.out.println(knight1);
        System.out.println(knight2);
        for (Armor armor : knight2.clothes) {
            System.out.println(armor);
        }
        System.out.println();

        knight2.dress(new Helmet(5));

        System.out.println(knight1);
        System.out.println(knight2);
        for (Armor armor : knight2.clothes) {
            System.out.println(armor);
        }
        System.out.println();
    }
}
