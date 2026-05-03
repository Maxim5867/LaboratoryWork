import java.util.Scanner;
import java.util.Stack;

public class N20 {
    public static void main(String[] args) {
        System.out.println(isValid("([)]"));
    }
    public static boolean isValid(String s) {
        boolean flag = false;
        Stack<String> stack = new Stack<>();
        String[] array = s.replaceAll(" ", "").split("");
        for (int i = 0; i < array.length; i++) {
            stack.push(array[i]);
        }
        System.out.println(stack);
        if (stack.search("(") > -1){
            stack.push("(");
            if (stack.search(")") > -1){
                if (stack.peek().equals("(")){
                    stack.pop();
                    flag = true;
                }
            }
        } else if (stack.search("[") > -1){
            stack.push("[");
            if (stack.search("]") > -1){
                if (stack.peek().equals("[")){
                    stack.pop();
                    flag = true;
                }
            }
        } if (stack.search("{") > -1){
            stack.push("{");
            if (stack.search("}") > -1){
                if (stack.peek().equals("{")){
                    stack.pop();
                    flag = true;
                }
            }
        }
        return flag;
    }
}
