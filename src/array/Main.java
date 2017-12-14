package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static int result = 1;
    public static List<Integer> layer = new ArrayList<>();

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String str = read.nextLine();
        Analys(str);
        for (int i = 0; i < layer.size(); ++i) {
            result *= layer.get(i);
        }
        System.out.println(result);
    }

    public static void Analys(String str) {

        if (str.equals("()")) {
            layer.add(1);
            return;
        }

        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == '(') {
                str = str.substring(0,i) + str.substring(i+1, str.length());
                break;
            }
        }
        int count = 0;
        String tempStr = "";
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == ')') {
                String newStr = str.substring(0,i) + str.substring(i+1, str.length());
                if (isOk(newStr)) {
                    tempStr = newStr;
                    ++count;
                }
            }
        }
        layer.add(count);
        Analys(tempStr);

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