package string;

import java.util.LinkedList;
import java.util.List;

/**
 * @author RiverLea
 * @version 1.0
 * @since JDK 1.8
 * Date   2017/8/15 14:52
 */

public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        StringBuilder path = new StringBuilder();
        if (n > 0) {
            generate(n, path, result, 0, 0);
        }
        return result;
    }

    private static void generate(int n, StringBuilder path, List<String> result,
                                 int l, int r) {
        if (l == n) {
            StringBuilder sb = new StringBuilder(path);
            for (int i = 0; i < n - r; ++i) {
                sb.append(')');
            }
            result.add(sb.toString());
            return;
        }

        path.append('(');
        generate(n, path, result, l + 1, r);
        path.deleteCharAt(path.length() - 1);

        if (l > r) {
           path.append(')');
           generate(n, path, result, l, r + 1);
           path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
