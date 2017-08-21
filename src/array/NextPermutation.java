package array;

import java.util.Arrays;

/**
 * @author RiverLea
 * @version 1.0
 * @since JDK 1.8
 * Date   2017/8/15 21:01
 */

public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int index = nums.length - 1;
        if (nums.length <= 1) {
            return;
        }
        while (index > 0 && nums[index] <= nums[index-1]) {
            index--;
        }
        if (index == 0) {
            Arrays.sort(nums);
            return;
        } else if (index == nums.length -1) {
            int temp = nums[index];
            nums[index] = nums[index-1];
            nums[index-1] = temp;
            return;
        }
        int pos = index - 1;
        for(int i = index + 1; i < nums.length; ++i) {
            if (nums[pos] >= nums[pos+2]) {
                int temp = nums[pos];
                nums[pos] = nums[index];
                nums[index] = temp;
                break;
            }
            if (nums[i] > nums[pos]) {
                if(i == nums.length - 1) {
                    int temp = nums[pos];
                    nums[pos] = nums[i];
                    nums[i] = temp;
                    break;
                }
                continue;
            } else {
                int temp = nums[pos];
                nums[pos] = nums[i-1];
                nums[i-1] = temp;
                break;
            }
        }
        Arrays.sort(nums, index, nums.length);
        return;
    }

    public static void main(String[] args) {
        int[] nums = {5,4,7,5,3,2};
        nextPermutation(nums);
        ArrayPrinter.print(nums);
    }
}
