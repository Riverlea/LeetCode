package string;

import java.util.Stack;

/**
 * @author RiverLea
 * @version 1.0
 * @since JDK 1.8
 * Date   2017/8/15 22:20
 */

public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        int maxLen = 0;
        int last = -1;

        Stack<Integer> lefts = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                lefts.push(i);
            } else {
                if (lefts.empty()) {
                    last = i;
                } else {
                    lefts.pop();
                    if (lefts.empty()) {
                        maxLen = Math.max(maxLen, i - last);
                    } else {
                        maxLen = Math.max(maxLen, i - lefts.peek());
                    }
                }
            }
        }
        return maxLen;
    }


    public static void main(String[] args) {
        System.out.println(longestValidParentheses("((((((((()"));
    }
}
