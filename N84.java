import java.util.Scanner;

public class N84 {
    public static void main(String[] args) {
        int booksAmount = 0;
        int currentBook = 0;
        String title;
        String input;
        String title_search = "";
        int prov = 1;

        Scanner consolscanner = new Scanner(System.in);

        while (true) {
            switch (prov) {
                case 1 -> System.out.print("Введите количество книг на полке\n-> ");
                case 2 -> System.out.print("Введите название книги, которую хотите найти\n-> ");
                default -> System.out.println("Введите название книги " + (currentBook + 1));
            }
            input = consolscanner.nextLine();
            if (!input.equalsIgnoreCase("stop")){
//                if (input.matches("[0-9]+") && prov != 1) {
                if (input.matches("[0-9]+") && prov != 1) {
                    prov = 1; currentBook = 0;
                }
                switch (prov) {
                    case 1:
                        booksAmount = Integer.parseInt(input);
                        if (booksAmount > 0) {
                            prov = 2;
                        } else { return; }
                        break;
                    case 2:
                        title_search = input;
                        prov = 3;
                        break;
                    default:
                        currentBook += 1;
                        title = input;
                        if (title.equals(title_search)) {
                            System.out.println("Checked " + booksAmount + " books and found " + title);
                            return;
                        }
                }
                if (currentBook == booksAmount) {
                    System.out.println("You checked " + booksAmount + " books and did not find " + title_search);
                    break;
                }
            } else {
                break;
            }

        }
    }
}
