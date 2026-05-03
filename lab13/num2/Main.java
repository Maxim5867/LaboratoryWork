package lab13.num2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Catalog catalog = new Catalog(list);
        Scanner scanner = new Scanner(System.in);
        while (true){
            String input = scanner.nextLine();
            String[] array = new String[]{};
            String[] arrayTest = input.split(" ");
            if (arrayTest[0].equals("search")) {
                array = input.split(" ");
            } else array = input.split(", ");
            if (array[0].equalsIgnoreCase("search")){
                System.out.println(catalog.search(array[1]));
                catalog.toString();
            } else if (array[0].equalsIgnoreCase("stop")) {
                Collections.sort(list);
                System.out.println(catalog.toString());
                break;
            } else {
                boolean flag = true;
                String[] currentString = new String[]{};
                for (int i = 0; i < list.size(); i++) {
                    currentString = list.get(i).split(", ");
                    if (array[1].equals(currentString[1])){
                        list.remove(i);
                        list.add(input);
                        flag = false;
                    }
                }
                if (flag) {
                    catalog.addElement(input);
                }
            }
        }
    }
}
