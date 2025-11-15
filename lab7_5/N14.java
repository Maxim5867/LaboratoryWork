package lab7_5;

import java.util.Scanner;

public class N14 {
    public static void main(String[] args) {
        int RC = 0;
        int[][] nums = {};
        String input;
        Scanner sc = new Scanner(System.in);
        int index1 = 0, index2 = 0;
        int amount = 0;

        for (;;) {
            try {
                if (RC == 0) {
                    System.out.print("enter the RC: ");
                    input = sc.nextLine();
                    RC = Integer.parseInt(input);
                    if (RC > 0 && RC % 2 == 0) {
                        nums = new int[RC][RC];
                    } else {
                        RC = 0;
                        System.out.println("Try again");
                        continue;
                    }
                }
                System.out.println("enter the numbers:");
                input = sc.nextLine();
                for (String element : input.split(" ")) {
                    if (!element.isEmpty()) {
                        nums[index1][index2] = Integer.parseInt(element);
                        amount++; index2++;
                        if (index2 == RC) { index1++; index2 = 0; }
                        if (amount == RC*RC) { break; }
                    }
                }
                if (amount < RC*RC) {
                    System.out.println("Try again");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Try again");
                continue;
            }

            for (int i = 0; i < RC; i++) {
                for (int j = 0; j < RC; j++) {
                    System.out.print(nums[i][j] + " ");
                }
                System.out.println();
            }

            int[] sums = new int[4];

            for (int i = 0; i < RC/2; i++) {
                for (int j = 0; j < RC/2; j++) {
                    sums[0] += nums[i][j];
                }
                for (int j = RC/2; j < RC; j++) {
                    sums[1] += nums[i][j];
                }
            }
            for (int i = RC/2; i < RC; i++) {
                for (int j = 0; j < RC/2; j++) {
                    sums[3] += nums[i][j];
                }
                for (int j = RC/2; j < RC; j++) {
                    sums[2] += nums[i][j];
                }
            }

            for (int sum : sums) {
                System.out.print(sum + " ");
            }
            break;
        }
    }
}
