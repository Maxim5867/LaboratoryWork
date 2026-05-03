package lab11.num2;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.regex.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Main {
    static String path = "resources\\num2.txt";

    public static void main(String[] args) {
        List<String> lines = new ArrayList<>();

        if (Files.exists(Paths.get(path))) {
            try (Scanner scanner = new Scanner(new FileReader(path))) {
                while (scanner.hasNextLine()) {
                    lines.add(scanner.nextLine());
                }
            } catch (IOException e) {
                System.out.println("Ошибка: " + e.getMessage());
                return;
            }
        }

        try (FileWriter writer = new FileWriter(path, false)) {
            for (String line : lines) {
                String result = solveTask(line);
                writer.write(line + "=" + result + System.lineSeparator());
            }
            writer.flush();
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }
    }

    private static String solveTask(String input) {
        if (input == null || input.isEmpty()) return "invalid1";

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') ||
                    c == ',' || c == '.' || c == '+') {
                return "invalid2";
            }
        }

        try {
            if (input.contains("--")) return "invalid3";

            List<Integer> numbers = new ArrayList<>();

            int i = 0;
            int length = input.length();

            while (i < length) {
                char currentChar = input.charAt(i);

                if (currentChar == ' ') {
                    i++;
                    continue;
                }
                if (currentChar == ')'){
                    i++;
                    continue;
                }

                if (currentChar == '(') {
                    int start = i + 1;
                    int end = start;

                    while (end < length && input.charAt(end) != ')') {
                        end++;
                    }

                    if (end < length) {
                        String numStr = input.substring(start, end);
                        if (isValidNumber(numStr)) {
                            numbers.add(Integer.parseInt(numStr));
                        } else {
                            return "invalid4";
                        }
                        i = end + 1;
                    } else {
                        return "invalid5";
                    }
                }
                else if (currentChar == '-') {
                    int start = i;
                    int end = i + 1;

                    while (end < length && Character.isDigit(input.charAt(end))) {
                        end++;
                    }

                    if (end > start) {
                        if (end < length && input.charAt(end) == '('){
                            if (input.charAt(end+1) == '-') {
                                end += 2;
                                numbers.add(Integer.parseInt(String.valueOf(input.charAt(end))));
                                end++;
                                i = end;
                            }
                        }
                        else if (end <= length) {
                            String numStr = input.substring(start, end);
                            System.out.println(numStr);
                            System.out.println(end);
                            numbers.add(Integer.parseInt(numStr));
                            i = end;
                        }
                    } else {
                        return "invalid6";
                    }
                }
                else if (Character.isDigit(currentChar)) {
                    int start = i;
                    int end = i;

                    while (end < length && Character.isDigit(input.charAt(end))) {
                        end++;
                    }

                    String numStr = input.substring(start, end);
                    numbers.add(Integer.parseInt(numStr));
                    i = end;
                }
                else {
                    return "invalid7";
                }
            }

            if (numbers.isEmpty()) return "invalid8";

            int res = numbers.get(0);
            for (int k = 1; k < numbers.size(); k++) {
                res += numbers.get(k);
            }

            return String.valueOf(res);
        } catch (Exception e) {
            return "invalid9";
        }
    }

    private static boolean isValidNumber(String str) {
        if (str == null || str.isEmpty()) return false;

        int start = 0;
        if (str.charAt(0) == '-') {
            if (str.length() == 1) return false;
            start = 1;
        }

        for (int i = start; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}


