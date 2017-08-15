package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author RiverLea
 * @version 1.0
 * @since JDK 1.8
 * Date   2017/8/12 21:11
 */

public class TwoSum {

    static int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int begin = 0;
        int end = nums.length - 1;
        while(begin != end) {
            int flag = nums[begin] + nums[end];
            if(flag == target) {
                return new int[]{begin, end};
            }
            else if(flag > target) {
                end--;
            }
            else {
                begin++;
            }
        }
        return new int[] {0, 0};
    }

    static int[] other(int[] nums, int target) {
        Map<Integer, Integer> order = new HashMap<>();
        int index = 0;
        for(int i : nums) {
            order.put(i, index++);
        }
        for(int i = 0; i < nums.length; i++) {
            Integer key = order.get(target - nums[i]);
            if (key != null && key > i)
                return new int[]{i, order.get(target - nums[i])};
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int[] result = other(nums, 6);
        ArrayPrinter.print(result);
    }
}
