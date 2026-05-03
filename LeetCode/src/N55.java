public class N55 {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,0}));
    }
    public static boolean canJump(int[] nums) {
        return recurse(0,nums) == 1;
    }

    public static int recurse(int currentIndex, int[] nums){
        if (currentIndex == nums.length-1){
            return 1;
        } else if (nums[currentIndex] == 0) {
            return 0;
        } else {
            int k = 0;
            for (int i = 1; i < nums[currentIndex]+1; i++) {
                if (currentIndex+i <nums.length) {
                    k += recurse(currentIndex + i, nums);
                }
            }
            if (k!=0){
                return 1;
            } else return 0;
        }
    }
}
