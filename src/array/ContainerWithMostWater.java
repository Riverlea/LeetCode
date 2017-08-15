package array;

/**
 * @author RiverLea
 * @version 1.0
 * @since JDK 1.8
 * Date   2017/8/14 19:35
 */

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int begin = 0;
        int end = height.length - 1;
        int result = Integer.MIN_VALUE;
        while (begin < end) {
            int area = Math.min(height[end], height[begin]) * (end - begin);
            result = Math.max(result, area);
            if (height[begin] <= height[end]) {
                begin++;
            } else {
                end--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 4, 9, 4}));
    }
}
