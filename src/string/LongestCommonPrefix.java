package string;

/**
 * @author RiverLea
 * @version 1.0
 * @since JDK 1.8
 * Date   2017/8/14 21:09
 */

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        for (int i = 0; i < strs[0].length(); ++i) {
            for (int j = 0; j < strs.length; ++j) {
                if (i == strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        String[] strs = {
                "fish",
                "fizz",
                "fiver"
        };
        System.out.println(longestCommonPrefix(strs));
    }
}
