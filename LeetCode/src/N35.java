public class N35 {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6}, 2));
    }
    public static int searchInsert(int[] nums, int target) {
        int max = 0;
        int index = 0;
        boolean condition = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target){
                index = i;
                System.out.println(index);
                condition = true;
            }
        }
        if (!condition){
            for (int i = 0; i < nums.length; i++) {
                if (target > nums[i]){
                    index = i+1;
                }
            }
        }
        return index;
    }
}
