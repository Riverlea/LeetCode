package list;

import java.util.*;

/**
 * @author RiverLea
 * @version 1.0
 * @since JDK 1.8
 * Date   2017/9/9 15:41
 */

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String str = read.nextLine();
        Map<String, String> highCache = new HashMap<>();
        Map<String, Boolean> cache = new HashMap<>();
        Set<String> result = new HashSet<>();
        result.clear();
        for (int i = 0; i < str.length(); ++i) {
            String tempStr = str.substring(0, i) + str.substring(i+1, str.length());
            for (int j = 0 ; j < tempStr.length(); ++j) {
                String lStr;
                String rStr;
                if (j == tempStr.length() - 1) {
                    lStr = tempStr + "(";
                    rStr = tempStr + ")";
                } else {
                    lStr = tempStr.substring(0, j) + "(" + tempStr.substring(j, tempStr.length());
                    rStr = tempStr.substring(0, j) + ")" + tempStr.substring(j, tempStr.length());
                }
                if (cache.get(lStr) == null) {
                    Boolean bool = isOk(lStr);
                    cache.put(lStr, bool);
                }
                if (cache.get(rStr) == null) {
                    Boolean bool = isOk(rStr);
                    cache.put(rStr, bool);
                }

                if (cache.get(lStr) && !lStr.equals(str)) {
                    result.add(lStr);
                    highCache.put(tempStr, tempStr);
                }
                if (cache.get(rStr) && !rStr.equals(str)) {
                    result.add(rStr);
                }

            }
        }
        System.out.println(result.size());
    }

    public static boolean isOk(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
