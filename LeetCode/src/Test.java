public class Test {
    public static void main(String[] args) {
        int reverseNum = 25;
        int n = 25;
        String str1 = "";
        String str = String.valueOf(reverseNum);
        for (int i = str.length()-1; i >= 0; i--) {
            str1 += str.charAt(i);
        }
        reverseNum = Integer.parseInt(str1);
        System.out.println(Math.abs(n-reverseNum));
    }
}
