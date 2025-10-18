import java.util.Scanner;

public class N75 {
    public static void main(String[] args) {
        String input;
        int num;
        int min_prime_num = Integer.MAX_VALUE;
        int nonPrimeNumsSum = 0;
        int nonPrimeNumsAmount = 0;
        boolean isPrime;
        boolean isPrimeNumEntered = false;
        Scanner consolscanner = new Scanner(System.in);

        for(;;) {
            System.out.print("Введи число или 'stop' для прекращения ввода\n>>>");
            input = consolscanner.nextLine();
            if (!input.equalsIgnoreCase("stop")) {
                num = Integer.parseInt(input);
                if (num > 2) {
                    isPrime = true;
                    for (int i = 2; i < num/2+1; i++) {
                        if (num % i == 0) {
                            isPrime = false;
                            break;
                        }
                    }
                    if (isPrime){
                        isPrimeNumEntered = true;
                        if (num < min_prime_num) { min_prime_num = num; }
                    } else {
                        nonPrimeNumsAmount += 1;
                        nonPrimeNumsSum += num;
                    }
                } else { System.out.println("invalid"); }
            } else {
                if (isPrimeNumEntered) { System.out.println("prime_" + min_prime_num); }
                else { System.out.println("prime_undefined"); }
                if (nonPrimeNumsAmount != 0) { System.out.println("non_prime_" + nonPrimeNumsSum/nonPrimeNumsAmount); }
                else { System.out.println("non_prime_undefined"); }
                break;
            }
        }
    }
}

