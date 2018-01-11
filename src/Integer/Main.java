package Integer;

import java.util.Scanner;

/**
 * @author RiverLea
 * @version 1.0
 * @since JDK 1.8
 * Date   2017/9/9 15:41
 */

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        final int times = read.nextInt();
        String[] result = new String[times];
        for (int i = 0; i < times; ++i) {
            final int n = read.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; ++j) {
                nums[j] = read.nextInt();
            }
            int fourCount = 0;
            int TwoCount = 0;
            for (int num : nums) {
                if (num % 4 == 0) {
                    fourCount++;
                } else if (num % 2 == 0) {
                    TwoCount++;
                }
            }
            if (fourCount*2 + TwoCount-1 >= n - 1) {
                result[i] = "Yes";
            } else {
                result[i] = "No";
            }
        }
        for (String str : result) {
            System.out.println(str);
        }
    }
}
