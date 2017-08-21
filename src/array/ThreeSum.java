package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author RiverLea
 * @version 1.0
 * @since JDK 1.8
 * Date   2017/8/15 13:22
 */

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        final int target = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; ++i) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                if (nums[j] + nums[i] + nums [k] < target) {
                    ++j;
                    while(nums[j] == nums[j-1] && j < k){
                        ++j;
                    }
                } else if (nums[i] + nums[j] + nums[k] > target) {
                    --k;
                    while(nums[k] == nums[k+1] && j < k) {
                        --k;
                    }
                } else {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    ++j;
                    --k;
                    while(nums[j] == nums[j-1] && j < k) {
                        ++j;
                    }
                    while(nums[k] == nums[k+1] && j < k) {
                        --k;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,-1,0,2,-2,3};
        System.out.println(threeSum(nums));
    }
}
