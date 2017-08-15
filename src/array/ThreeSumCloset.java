package array;

import java.util.Arrays;

/**
 * @author RiverLea
 * @version 1.0
 * @since JDK 1.8
 * Date   2017/8/15 13:43
 */

public class ThreeSumCloset {
    public static int threeSumClosest(int[] nums, int target) {
        int result = 0;
        int minGap = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; ++i) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                final int sum = nums[i] + nums[j] + nums[k];
                final int gap = Math.abs(sum - target);
                if (gap < minGap) {
                    result = sum;
                    minGap = gap;
                }

                if(sum < target) {
                    ++j;
                } else {
                    --k;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, 3};
        System.out.println(threeSumClosest(nums,4));
    }
}
