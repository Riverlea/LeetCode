package Integer;

/**
 * @author RiverLea
 * @version 1.0
 * @since JDK 1.8
 * Date   2017/8/14 16:01
 */

public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        int d = 1;
        while(x / d >= 10){
            d *=  10;
        }
        while(x > 0) {
            int q = x / d;
            int r = x % 10;
            if (q != r) {
                return false;
            }
            x = x % d / 10;
            d /= 100;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(3425243));
    }
}
