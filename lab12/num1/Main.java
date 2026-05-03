package lab12.num1;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String[] input = scanner.nextLine().replaceAll(" ", "").split("");
//        int[] array = new int[input.length];
//        for (int i = 0; i < input.length; i++) {
//            array[i] = Integer.parseInt(input[i]);
//        }
        CustomStack stack = new CustomStack(new int[]{});
        System.out.println(stack.isEmpty());
        stack.push(10);
        System.out.println(stack.toString());
        System.out.println(stack.isEmpty());
    }
}
