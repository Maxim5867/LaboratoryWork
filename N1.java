import java.util.Scanner;
public class N1 {
    public static void main(String[] args) {
        Scanner consolscanner = new Scanner(System.in);
        System.out.print("Введите число a\n->  ");
        int a = consolscanner.nextInt();
        System.out.print("Введите число b\n->  ");
        int b = consolscanner.nextInt();
        System.out.print("Введите число N\n->  ");
//        int N = consolscanner.nextInt();
        int N = 1;
        double leftPart = (N+2)/Math.pow((Math.abs(a*b)), 0.5);
        double rightPart = Math.pow(b, 2)/N;
        double result = leftPart - rightPart;
        System.out.printf("%.3f", result); //вывести три знака
    }
}
