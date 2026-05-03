package lab9.num1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner consolscanner = new Scanner(System.in);
        Vehicle info = new Boat(consolscanner.nextInt(), consolscanner.nextInt());
        System.out.println(info);
    }
}
