package string;

import java.util.Arrays;

/**
 * @author RiverLea
 * @version 1.0
 * @since JDK 1.8
 * Date   2017/8/13 20:19
 */

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        if(s.equals(""))
            return 0;
        int max = 1;
        int length = 1;
        int begin = 0;
        int flag = 0;
        int temp = begin + length;
        int finish = 0;
        while(finish == 0 && begin + length < s.length()) {
            temp = begin + length;
            for(int i = begin; i < begin + length; i++) {
                if (s.charAt(i) == s.charAt(temp)) {
                    max = Math.max(max, length);
                    if(length + begin == s.length() - 1)
                        finish = 1;
                    length = 1;
                    begin = i + 1;
                    flag = 1;
                    break;
                }
            }
            if(flag == 0) {
                length += 1;
            }
            flag = 0;
        }
        return Math.max(max,length);
    }

    public static int betterSolution(String s) {
        final int ASCII = 128;
        int[] lastAppear = new int[ASCII];
        int start = 0;

        Arrays.fill(lastAppear, -1);
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if(lastAppear[s.charAt(i)] >= start) {
                maxLength = Math.max(i - start, maxLength);
                start = lastAppear[s.charAt(i)] + 1;
            }
            lastAppear[s.charAt(i)] = i;
        }
        return Math.max(s.length() - start, maxLength);
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("asdc"));
        System.out.println(betterSolution("fdadfffesadfaedfw"));
    }
}
