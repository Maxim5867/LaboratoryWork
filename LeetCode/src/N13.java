import java.util.Arrays;
import java.util.Scanner;

public class N13 {
    public static void main(String[] args) {
        int sum = 0;
        //for me, for LeetCode delete String 8 and 9
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] array = (s.replaceAll(" ","").split(""));
        if (array.length >= 1 && array.length <= 15){
            for (int i = 0; i < array.length; i++) {
                try {
                    switch (array[i]) {
                        case "I":
                            switch (array[i + 1]) {
                                case "M" -> {
                                    sum += 1000 - 1;
                                    array[i + 1] = "";
                                }
                                case "D" -> {
                                    sum += 500 - 1;
                                    array[i + 1] = "";
                                }
                                case "C" -> {
                                    sum += 100 - 1;
                                    array[i + 1] = "";
                                }
                                case "L" -> {
                                    sum += 50 - 1;
                                    array[i + 1] = "";
                                }
                                case "X" -> {
                                    sum += 10 - 1;
                                    array[i + 1] = "";
                                }
                                case "V" -> {
                                    sum += 5 - 1;
                                    array[i + 1] = "";
                                }
                                default -> sum += 1;
                            }
                            break;
                        case "V":
                            switch (array[i + 1]) {
                                case "M" -> {
                                    sum += 1000 - 5;
                                    array[i + 1] = " ";
                                }
                                case "D" -> {
                                    sum += 500 - 5;
                                    array[i + 1] = " ";
                                }
                                case "C" -> {
                                    sum += 100 - 5;
                                    array[i + 1] = " ";
                                }
                                case "L" -> {
                                    sum += 50 - 5;
                                    array[i + 1] = " ";
                                }
                                case "X" -> {
                                    sum += 10 - 5;
                                    array[i + 1] = " ";
                                }
                                default -> sum += 5;
                            }
                            break;
                        case "X":
                            switch (array[i + 1]) {
                                case "M" -> {
                                    sum += 1000 - 10;
                                    array[i + 1] = " ";
                                }
                                case "D" -> {
                                    sum += 500 - 10;
                                    array[i + 1] = " ";
                                }
                                case "C" -> {
                                    sum += 100 - 10;
                                    array[i + 1] = " ";
                                }
                                case "L" -> {
                                    sum += 50 - 10;
                                    array[i + 1] = " ";
                                }
                                default -> sum += 10;
                            }
                            break;
                        case "L":
                            switch (array[i + 1]) {
                                case "M" -> {
                                    sum += 1000 - 50;
                                    array[i + 1] = " ";
                                }
                                case "D" -> {
                                    sum += 500 - 50;
                                    array[i + 1] = " ";
                                }
                                case "C" -> {
                                    sum += 100 - 50;
                                    array[i + 1] = " ";
                                }
                                default -> sum += 50;
                            }
                            break;
                        case "C":
                            switch (array[i + 1]) {
                                case "M" -> {
                                    sum += 1000 - 100;
                                    array[i + 1] = " ";
                                }
                                case "D" -> {
                                    sum += 500 - 100;
                                    array[i + 1] = " ";
                                }
                                default -> sum += 100;
                            }
                            break;
                        case "D":
                            switch (array[i + 1]) {
                                case "M" -> {
                                    sum += 1000 - 500;
                                    array[i + 1] = " ";
                                }
                                default -> sum += 500;
                            }
                            break;
                        case "M":
                            sum += 1000;
                            break;
                    }
                } catch (IndexOutOfBoundsException e){
                    switch (array[i]) {
                        case "I" -> sum += 1;
                        case "V" -> sum += 5;
                        case "X" -> sum += 10;
                        case "L" -> sum += 50;
                        case "C" -> sum += 100;
                        case "D" -> sum += 500;
                        case "M" -> sum += 1000;
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
