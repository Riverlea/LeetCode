package Integer;

/**
 * @author RiverLea
 * @version 1.0
 * @since JDK 1.8
 * Date   2017/8/14 15:28
 */

public class ReverseInteger {

    public static int reverse(int x) {
        long result = 0;
        long temp = x;
        temp = temp > 0 ? temp : -temp;
        for(; temp > 0; temp /= 10) {
            result = result * 10 + temp % 10;
        }
        boolean flag = x <= 0;
        if(result > 2147483647 || (flag && result > Integer.MAX_VALUE)) {
            return 0;
        } else {
            if(flag) {
                return (int)-result;
            } else {
                return (int)result;
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(reverse(5235434));
    }
}
