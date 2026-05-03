package lab12.num2;

import lab12.num1.LIFO;

import java.util.Arrays;

public class CustomStacks implements LIFO {
    private int[] array;

    public CustomStacks(int[] array) {
        this.array = array;
    }

    public void toNumberSystem(int numberSystem){

    }

    @Override
    public void push(int e) {
        int len = array.length;
        int[] array1 = new int[len+1];
        for (int i = 0; i < len; i++) {
            array1[i] = array[i];
        }
        array1[len] = e;
        array = array1;
    }

    @Override
    public int pop() {
        int len = array.length;
        int delNumber = array[len-1];
        int[] array1 = new int[len-1];
        for (int i = 0; i < len-1; i++) {
            array1[i] = array[i];
        }
        array = array1;
        return delNumber;
    }

    public boolean isEmpty(){
        return array.length == 0;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = array.length-1; i >= 0; i--) {
            str.append(array[i]);
        }
        return str.toString();
    }
}
