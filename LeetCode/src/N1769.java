import java.util.Arrays;

public class N1769 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(minOperations("001011")));
    }
    public static int[] minOperations(String boxes) {
        int numberArray = 0;
        int[] array = new int[boxes.length()];
        for (int i = 0; i < boxes.length(); i++) {
            for (int j = 0; j < boxes.length(); j++) {
                if (j == i) continue;
                if (boxes.charAt(j) == '1') {
                    numberArray += Math.abs(i-j);
                }
            }
            array[i] = numberArray;
            numberArray = 0;
        }









//            if (i+k < boxes.length()) {
//                if (boxes.charAt(i + k) == '1') {
//                    numberArray += i + k;
//                    k++;
//                } else k = 1;
//            }
//            else if (i-k > -1) {
//                if (boxes.charAt(i-k) == '1') {
//                    numberArray += Math.abs(i - k);
//                    k++;
//                }
//            } else {
//                i++;
//                array[i] = numberArray;
//            }
        return array;
    }
}
