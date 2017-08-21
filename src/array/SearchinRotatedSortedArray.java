package array;

/**
 * @author RiverLea
 * @version 1.0
 * @since JDK 1.8
 * Date   2017/8/21 15:08
 */

public class SearchinRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int first = 0;
        int last = nums.length;
        while (first != last) {
            int mid = first + (last - first) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[first] <= nums[mid]) {
                if (nums[first] <= target && target < nums[mid]) {
                    last = mid;
                } else {
                    first = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[last-1]) {
                    first = mid + 1;
                } else {
                    last = mid;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,1,2,3},2));
    }

}
