package lab6_3;

import java.util.Scanner;

public class N11 {
    public static void main(String[] args) {
        String input;
        boolean first = true;
        int sum = 0;
        String[] array;
        Scanner consolscanner = new Scanner(System.in);

        for (;;) {
            try {
                System.out.print("Введите числа через пробел\n-> ");
                input = consolscanner.nextLine();
                array = input.split(" ");
                for (int i = 0; i < array.length; i++) {
                    sum += Integer.parseInt(array[i]);
                }
            } catch (NumberFormatException exception) {
                System.out.println("Please, try again");
                continue;
            }
            System.out.println("Сумма элементов в массиве равна: " + sum);
            System.out.println("Количество элементов в массиве: " + array.length);
            int left, right, center;
            for (int i = 1; i < array.length - 1; i++) {
                left = Integer.parseInt(array[i - 1]);
                right = Integer.parseInt(array[i + 1]);
                center = Integer.parseInt(array[i]);
                if ((left < center) && (center > right)) {
                    if (!first) {
                        System.out.print(" ");
                    }
                    System.out.print(center);
                    first = false;
                }
            }
            break;
        }
    }
}

