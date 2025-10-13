import java.util.Scanner;

public class N5 {
    public static void main(String[] args) {
        Scanner consolscanner = new Scanner(System.in);

        int N = 1;
        int x1 = N;
        int x2 = 5*N;
        //промежуток между x1 и x2 = от 1 до 5
        int y1 = 11*N;
        int y2 = 15*N;
        //промежуток между y1 и y2 = от 11 до 15

        while (true) {
            System.out.print("Введите число\n-> ");
            int input = consolscanner.nextInt();
            if ((input >= x1 && input <= x2) || (input >= y1 && input <= y2)){
                System.out.println("Correct_number_" + input);
                break;
            } else {
                System.out.println("Not_yet");
            }
        }
    }
}
