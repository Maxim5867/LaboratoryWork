import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N2161 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(pivotArray(new int[]{9, 12, 5, 10, 14, 3, 10}, 10)));
    }
    public static int[] pivotArray(int[] nums, int pivot) {
        int[] array = new int[nums.length];
        List<Integer> listLeft = new ArrayList<>();
        List<Integer> listRight = new ArrayList<>();
        List<Integer> listBetween = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot){
                listLeft.add(nums[i]);
            } else if (nums[i] > pivot){
                listRight.add(nums[i]);
            } else listBetween.add(nums[i]);
        }
        for (int i = 0; i < listLeft.size(); i++) {
            array[i] = listLeft.get(i);
        }
        for (int i = 0; i < listBetween.size(); i++) {
            array[i+listLeft.size()] = listBetween.get(i);
        }
        for (int i = 0; i < listRight.size(); i++) {
            array[i+listLeft.size()+listBetween.size()] = listRight.get(i);
        }
        return array;
    }
}
