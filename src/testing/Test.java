package testing;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author RiverLea
 * @version 1.0
 * @since JDK 1.8
 * Date   2017/10/17 19:46
 */

public class Test {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int n = read.nextInt();
        if (n == 1) {
            System.out.println(-1);
        } else {
            int[] nums = new int[n];
            int[] results= new int[n];
            for (int i = 0 ; i < n; ++i) {
                nums[i] = read.nextInt();
            }

            deal(nums, results);
            for (int i : results) {
                System.out.println(i);
            }
        }
    }
    public static void deal(int[] nums, int[] results) {
        Arrays.fill(results, -1);
        int max = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0 ; --i) {
            if (nums[i] >= max) {
                max = nums[i];
                continue;
            }
            for (int j = i; j < nums.length; ++j) {
                if (nums[j] > nums[i]) {
                    results[i] = nums[j];
                    break;
                }
            }
        }
    }
}
