package array;

/**
 * @author RiverLea
 * @version 1.0
 * @since JDK 1.8
 * Date   2017/8/15 18:02
 */

public class DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }

        //when diviend = INT_MIN , divisor = -1
        //result will overflow
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            } else if (divisor < 0) {
                return 1 + divide(dividend - divisor, divisor);
            } else {
                return -1 + divide(dividend + divisor, divisor);
            }
        }

        if (divisor == Integer.MIN_VALUE) {
            return dividend == divisor ? 1 : 0;
        }

        int a = dividend > 0 ? dividend : -dividend;
        int b = divisor > 0 ? divisor : -divisor;

        int result = 0;
        while (a >= b) {
            int c = b;
            for (int i = 0; a >= c;) {
                a -= c;
                result += 1 << i;
                if (c < Integer.MAX_VALUE / 2) {
                    ++i;
                    c = c << 1;
                }
            }
        }
        return ((dividend ^ divisor) >> 31) != 0 ? (-result) : result;
    }


    public static void main(String[] args) {
        System.out.println(divide(32, 11));
    }
}
