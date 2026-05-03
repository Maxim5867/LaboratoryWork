import java.util.HashSet;
import java.util.Set;

public class N3760 {
    public static void main(String[] args) {
        System.out.println(maxDistinct("abab"));
    }
    public static int maxDistinct(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        System.out.println(set);
        return set.size();
    }
}
