package lab12.num2;

import lab12.num1.CustomStack;

import java.util.Stack;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CustomStacks stack = new CustomStacks(new int[]{13, 8});
        CustomStacks stackRemains = new CustomStacks(new int[]{});
        int numberSystem = stack.pop();
        while (!stack.isEmpty()){
            int number = stack.pop();
            int remains = number%numberSystem;
            if (number/numberSystem != 0) {
                stack.push(number / numberSystem);
            }
            stackRemains.push(remains);
        }
        System.out.println(stackRemains.toString());
    }
}
