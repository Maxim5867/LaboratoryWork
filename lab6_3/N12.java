package lab6_3;

import java.util.Scanner;

public class N12 {
    public static void main(String[] args) {
        String[] arrayOne;
        boolean first = true;
        String[] arrayTwo;
        Scanner consolscanner = new Scanner(System.in);

        System.out.print("Введите значения первого массива\n-> ");
        arrayOne = consolscanner.nextLine().split(" ");
        System.out.print("Введите значения второго массива\n-> ");
        arrayTwo = consolscanner.nextLine().split(" ");

        for (String str: arrayTwo) {
            for (String str2: arrayOne) {
                if (str.equalsIgnoreCase(str2)){
                    if (!first) {
                        System.out.print(" ");
                    }
                    System.out.print(str);
                    first = false;
                }
            }
        }

    }
}
