package lab12.num1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomStack implements LIFO {
    private int[] array;

    public CustomStack(int[] array) {
        this.array = array;
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
        //for ArrayList
        //list.add(e);
    }

    @Override
    public int pop() {
        int len = array.length;
        int[] array1 = new int[len-1];
        for (int i = 0; i < len-1; i++) {
            array1[i] = array[i];
        }
        array = array1;

        //for ArrayList
//        int len = list.size();
//
//        int obj = list.remove(len - 1);
//        list.remove(len - 1);
//
//        return obj;
        return 10;
    }

    public boolean isEmpty(){
        return array.length == 0;
        //for ArrayList
//        return list.isEmpty();
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
