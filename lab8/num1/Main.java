package lab8.num1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner consolscanner = new Scanner(System.in);
        Cylinder cylinder1 = new Cylinder(consolscanner.nextInt(), consolscanner.nextInt());
        Cylinder cylinder2 = new Cylinder(consolscanner.nextInt(), consolscanner.nextInt());

        int area1 = cylinder1.getArea();
        int volume1 = cylinder1.getVolume();

        int area2 = cylinder2.getArea();
        int volume2 = cylinder2.getVolume();

        System.out.println(area1);
        System.out.println(volume1);
        System.out.println(area2);
        System.out.println(volume2);

        if (cylinder1.isEqualAreas(cylinder2)) {
            System.out.println("Areas is equal");
        } else System.out.println("Areas is not equal");

        if (!cylinder1.isEqualVolume(cylinder2)) {
            System.out.println("Volume is not equal");
        }
        else System.out.println("Volume is equal");
    }
}

