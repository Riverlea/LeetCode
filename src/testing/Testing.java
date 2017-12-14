package testing;

import java.util.Scanner;

/**
 * @author RiverLea
 * @version 1.0
 * @since JDK 1.8
 * Date   2017/10/17 19:36
 */

public class Testing {
    public static void main(String args[]) {
        Scanner read = new Scanner(System.in);
        long m = read.nextLong();
        long n = read.nextLong();
        if (m < n) {
            long temp = m;
            m = n;
            n = temp;
        }
        while(m % n != 0) {
            long temp = m % n;
            m = n;
            n = temp;
        }
        System.out.println(n);
    }
}
