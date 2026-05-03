import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class N1689 {
    public static void main(String[] args) {
        System.out.println(minPartitions("32"));
    }
    public static int minPartitions(String n) {
        int max = n.charAt(0) - '0';
        for (char chr : n.toCharArray()) {
            max = Math.max(max,chr-'0');
        }
        return max;
    }
}
