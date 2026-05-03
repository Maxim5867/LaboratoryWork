import java.util.Scanner;

public class N14 {
    public static void main(String[] args) {
        String prefix = "";
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] array = s.split(" ");
        for (int i = 0; i < array.length; i++){
            if (i + 1 < array.length) {
                for (int j = 0; j < array.length+1; j++) {
                    if (array[i].substring(0,j).equals(array[i + 1].substring(0,j))) {
                        prefix = array[i].substring(0, j);
                    }
                }
            }
        }
        System.out.println(prefix);
    }
}
