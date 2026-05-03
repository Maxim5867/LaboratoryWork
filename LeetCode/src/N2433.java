import java.util.Arrays;

public class N2433 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findArray(new int[]{5, 2, 0, 3, 1})));
    }
    public static int[] findArray(int[] pref) {
        int[] array = new int[pref.length];
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == 0){
                array[i] = pref[i];
            } else {
                array[i] = pref[i-1]^pref[i];
            }
        }
        return array;
    }
}
