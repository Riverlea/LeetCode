package array;

import java.util.Scanner;

/**
 * @author RiverLea
 * @version 1.0
 * @since JDK 1.8
 * Date   2017/8/21 19:18
 */

public class Main {
/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static int pick(int[] peaches) {
        if (peaches.length == 0) {
            return 0;
        } else if (peaches.length == 1) {
            return 1;
        }

        int max = 1;
        for (int i = peaches.length - 2; i >= 0; --i) {
            int count = 0;
            for (int j = i + 1; j < peaches.length; ++j) {
                if (peaches[i] >= peaches[j]) {
                    ++count;
                }
            }
            max = Math.max(max, count);
        }

        return max;
    }

    static int better(int[] peaches, int i, int max) {
        if (i == peaches.length - 1){
            return 1;
        } else {
            if (peaches[i] > peaches[i + 1]) {

            }
        }
        return 0;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int trees = Integer.parseInt(in.nextLine().trim());
        int[] peaches = new int[trees];
        for (int i = 0; i < peaches.length; i++) {
            peaches[i] = Integer.parseInt(in.nextLine().trim());
        }
        System.out.println(pick(peaches));
    }
}