import java.util.Scanner;

public class N9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        String temp = "";
        String s = String.valueOf(x);
        for (int i = s.length()-1; i >= 0; i--) {
            temp += String.valueOf(s.charAt(i));
        }
        System.out.println(temp.equals(s));
    }
}
