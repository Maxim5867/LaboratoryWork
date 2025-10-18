import java.util.Scanner;

public class N74 {
    public static void main(String[] args) {
        int n = 1;//числа
        int min = Integer.MAX_VALUE;//минимальное число
        boolean prime;
        boolean checkUp = false;
        String input;
        Scanner consolscanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введите числа\n-> ");
            input = consolscanner.nextLine();
            if (!input.equalsIgnoreCase("stop")) {
                int num = Integer.parseInt(input);
                if (num > 1) {
                    prime = true;
                    for (int i = 2; i < (num / 2) + 1; i++) {
                        if (num % i == 0) {
                            prime = false;
                            break;
                        }
                    }
                    if (prime) {
                        checkUp = true;
                        if (num < min) {
                            min = num;
                        }
                    } else {
                        n *= num;
                    }
                } else {
                    System.out.println("invalid");
                }
            } else {
                if (checkUp) {
                    System.out.println("prime_" + min);
                } else {
                    System.out.println("prime_undefined");
                }
                if (n != 1) {
                    System.out.println("non_prime_" + n);
                } else {
                    System.out.println("non_prime_undefined");
                } break;
            }
        }
    }
}
