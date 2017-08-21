package string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author RiverLea
 * @version 1.0
 * @since JDK 1.8
 * Date   2017/8/15 20:14
 */

public class SubstringWithConcatenationOfAllWords {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new LinkedList<>();
        Map<String, Integer> cache = new HashMap<>();
        for (String word : words) {
            cache.put(word, cache.containsKey(word) ? cache.get(word) + 1 : 1);
        };

        int length = words[0].length();
        int end = s.length() - words.length * length + 1;
        for (int i = 0; i < end; ++i) {
            Map<String, Integer> copy = new HashMap<>(cache);
            for(int j = 0; j < words.length; ++j) {
                String sub = s.substring(i + j * length, i + j * length + length);
                if (copy.containsKey(sub)) {
                    int count = copy.get(sub);
                    if (count == 1) {
                        copy.remove(sub);
                    } else {
                        copy.put(sub, count - 1);
                    }
                    if (copy.isEmpty()) {
                        result.add(i);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"cd", "ef", "gh"};
        System.out.println(findSubstring("abcdefghig", words));
    }
}
