package lab7_5;

import java.util.Scanner;

public class N13 {
    public static void main(String[] args) {
        int N = 1;
        Scanner consolscnanner = new Scanner(System.in);
        System.out.print("Введите количество строк: ");
        int R = Integer.parseInt(consolscnanner.nextLine());
        System.out.print("Введите количество колонн: ");
        int C = Integer.parseInt(consolscnanner.nextLine());
        int[][] array = new int[R][C];

        for (int j = C-1; j >= 0; j--) {
            if ((C-1-j)%2==0) {
                for (int i = R-1; i >= 0; i--) {
                    array[i][j] = N++;
                }
            } else {
                for (int i = 0; i < R; i++) {
                    array[i][j] = N++;
                }
            }

        }
        System.out.println();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(array[i][j]);
                if (j < C - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
