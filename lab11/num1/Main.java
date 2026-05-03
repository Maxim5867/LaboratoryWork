package lab11.num1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    static String path = "resources\\num1.txt";
    public static void main(String[] args) {
        int count = 0;
        if (Files.exists(Paths.get(path))){
            File file = new File(path);
            try (FileReader in = new FileReader(path)){
                int i = 0;
                char[] alphabet = new char[]{'ц', 'к', 'й', 'н', 'г', 'ш', 'щ', 'з', 'х', 'ф', 'в', 'п', 'р', 'л', 'д', 'ж', 'ч', 'с', 'м', 'т', 'б'};
                while ((i = in.read()) != -1){
                    boolean flag = false;
                    for (char o: alphabet){
                        if (o == Character.toLowerCase((char) i)){
                            flag = true;
                            break;
                        }
                    }
                    if (flag){
                        count++;
                    }
                }
            } catch (IOException e){
                System.out.println("Exception " + e.getMessage());
            }

        } else System.out.println("Invalid path");
        System.out.println(count);
    }
}
