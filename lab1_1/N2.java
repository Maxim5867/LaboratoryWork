import java.util.Scanner;

public class N2 {
    public static void main(String[] args) {
        Scanner consolScanner = new Scanner(System.in);
        System.out.print("Введите строку, которую хотите преобразовать\n-> ");
        String word = consolScanner.next();

        System.out.print("Введите индекс первый\n-> ");
        int firstInd = consolScanner.nextInt();
        System.out.print("Введите индекс второй\n-> ");
        int secondInd = consolScanner.nextInt();
        word = word.substring(firstInd, secondInd+1);

        System.out.print("Введите символ, который хотите заменить\n-> ");
        String symbIn = consolScanner.next();
        System.out.print("Введите символ, на который хотите заменить\n-> ");
        String symbOn = consolScanner.next();
        String word2 = word.replace(symbIn,symbOn);

        String word3 = word2.toLowerCase();
        //System.out.println(word);
        //System.out.println(word2);
        System.out.println(word3);
    }
}
