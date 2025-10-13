import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
public class N4 {
    public static void main(String[] args) {
        int N = 1;
        Scanner consolscanner = new Scanner(System.in);
        System.out.print("Введите фрукт, который хотите купить\n-> ");
        String fruit = consolscanner.nextLine();
        double price;
        boolean condition1 = true;
        switch (fruit.toLowerCase()) {
            case "apple":
                price = 9.99; break;
            case "banana":
                price = 11.49; break;
            case "grapes":
                price = 15.99; break;
            case "kiwi":
                price = 37.99; break;
            case "mango":
                price = 39.99; break;
            case "orange":
                price = 17.99; break;
            case "plum":
                price = 10.98; break;
            default:
                condition1 = false;
                System.out.println("INVALID");
                price = 0;
        }
        if (condition1) {
            System.out.print("Введите день неделю\n-> ");
            String day = consolscanner.nextLine();
            double markup = 1.0;
            switch (day.toLowerCase()) {
                case "monday", "tuesday", "wednesday", "thursday", "friday":
                    break;
                case "saturday", "sunday":
                    if (fruit.equalsIgnoreCase("apple")||fruit.equalsIgnoreCase("banana")){
                        markup = 1.05;
                    }break;
                default:
                    System.out.println("INVALID");
                    condition1 = false;
            }
            if (condition1) {
                System.out.print("Введите количество киллограмм\n-> ");
                double kilos = Double.parseDouble(consolscanner.nextLine());
                if (kilos>=0) {
                    //System.out.printf("%.2f",price * kilos * N * markup);
                    double end = price*kilos*N*markup;
                    BigDecimal endUp = new BigDecimal(end).setScale(2,RoundingMode.CEILING);
                    System.out.print(endUp);
                } else System.out.println("INVALID");
            }
        }
    }
}
