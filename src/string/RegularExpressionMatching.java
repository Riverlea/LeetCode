package string;

/**
 * @author RiverLea
 * @version 1.0
 * @since JDK 1.8
 * Date   2017/8/14 16:14
 */

public class RegularExpressionMatching {
    public static boolean isMatch(String s, String p) {
        return helper(s, 0 , p, 0);
    }

    public static boolean helper(String s, int i, String p, int j) {
        if (j == p.length()) {
            return i == s.length();
        }

        final char b = p.charAt(j);
        if (j == p.length() - 1 || p.charAt(j + 1) != '*') {
            if (i < s.length() && b == s.charAt(i) || b == '.') {
                return helper(s, i + 1, p, j + 1);
            } else {
                return false;
            }
        } else {
            while (i < s.length() && (b == s.charAt(i) || b == '.')) {
                if (helper(s, i, p, j + 2))
                    return true;
                i++;
            }
            return helper(s, i, p, j + 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(isMatch("ab",".*c"));
    }
}
