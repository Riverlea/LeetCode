package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RiverLea
 * @version 1.0
 * @since JDK 1.8
 * Date   2017/8/15 13:50
 */

public class LetterCombinations {
    private static final String[] keyBoard = new String[]{
            " ", "", "abc", "def", "ghi", "jkl",
            "mno", "qprs", "tuv", "wxyz"
    };

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }
        dfs(digits, 0, "", result);
        return result;
    }

    private static void dfs(String digits, int cur, String path, List<String> result) {
        if(cur >= digits.length()) {
            result.add(path);
            return;
        }
        final String str = keyBoard[digits.charAt(cur) - '0'];
        if(!str.equals("")) {
            for (char c : str.toCharArray()) {
                dfs(digits, cur + 1, path + c, result);
            }
        } else {
            dfs(digits, cur + 1, path, result);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("21"));
    }
}
