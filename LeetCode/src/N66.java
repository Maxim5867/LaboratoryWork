import java.util.Arrays;

public class N66 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 3})));
    }
    public static int[] plusOne(int[] digits) {
        long numbers = 0;
        String resultString = "";
        for (int i = 0; i < digits.length; i++) {
            resultString += digits[i];
        }
        numbers = (Long.parseLong(resultString));
        numbers+=1;
        String[] array = String.valueOf(numbers).split("");
        int[] arr = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            arr[i] = Integer.parseInt(array[i]);
        }
        digits = arr;
        return digits;
    }
}
