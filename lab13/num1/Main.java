package lab13.num1;

import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        Treemap treemap = new Treemap(Integer.MAX_VALUE, "s");
        while (flag){
            try {
                String input = scanner.nextLine();
                String[] array = input.replaceAll("  ", " ").split(" ");
                switch (array[0]){
                    case "push":
                        treemap.setId(Integer.parseInt(array[1]));
                        treemap.setName(array[2]);
                        treemap.push();
                        System.out.println(treemap.toString());
                        break;
                    case "pop":
                        treemap.setId(Integer.parseInt(array[1]));
                        treemap.pop();
                        System.out.println(treemap.toString());
                        break;
                    case "search":
                        if (array[1].matches("[0-9]+")) {
                            treemap.setId(Integer.parseInt(array[1]));
                        }
                        else treemap.setName(array[1]);
                        treemap.search();
                        break;
                    case "stop":
                        flag = false;
                        break;
                    default:
                        System.out.println("Invalid command");

                }
            } catch (IllegalArgumentException e){
                System.out.println("Invalid data");
            }
        }
    }
}
