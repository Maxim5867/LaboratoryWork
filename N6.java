import java.util.Scanner;

public class N6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        int number;
        //int min_number = 999_999_999;
        int min_number = Integer.MAX_VALUE;
        boolean checkUp = false;
        do {
            System.out.print("Введите количество чисел\n-> ");
            n = Integer.parseInt(scanner.nextLine());
        } while (n <= 0);
        for (int i = 0; i < n; i++) {
            System.out.print("Введите число " + (i+1) + ": ");
            number = Integer.parseInt(scanner.nextLine());
            if (number >= 0) {
                checkUp = true;
                if (number < min_number) {
                    min_number = number;
                }
            }
        }
        if (checkUp) {
            System.out.println("Минимальное положительное число: " + min_number);
        } else {
            System.out.println("undefined");
        }
    }
}