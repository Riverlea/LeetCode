package array;

/**
 * @author RiverLea
 * @version 1.0
 * @since JDK 1.8
 * Date   2017/8/14 6:40
 */

public class MedianOfTwoSortedArrays {
    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sum = nums1.length + nums2.length;
        int[] arrays = new int[sum/2 + 1];
        int index1 = 0;
        int index2 = 0;
        for(int i = 0; i <= sum/2; i++) {
            if(index1 < nums1.length && index2 < nums2.length) {
                if(nums1[index1] <= nums2[index2]) {
                    arrays[i] = nums1[index1];
                    index1++;
                }
                else if(nums1[index1] > nums2[index2]) {
                    arrays[i] = nums2[index2];
                    index2++;
                }
            }
            else if(index1 == nums1.length && index2 < nums2.length) {
                arrays[i] = nums2[index2];
                index2++;
            }
            else {
                arrays[i] = nums1[index1];
                index1++;
            }
        }
        if(sum % 2 == 0) {
            return (arrays[sum/2 - 1] + arrays[sum/2])/2.0;
        } else {
            return arrays[sum/2];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
