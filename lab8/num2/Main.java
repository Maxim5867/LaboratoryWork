package lab8.num2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner consolscanner = new Scanner(System.in);
//        Cow cow = new Cow(consolscanner.nextLine(), consolscanner.nextLine(), consolscanner.nextInt());

        Cow cow = new Cow(null, null, 10);
        System.out.println(cow.getInfo());
    }

}
