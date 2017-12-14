package testing;

import java.util.Scanner;

/**
 * @author RiverLea
 * @version 1.0
 * @since JDK 1.8
 * Date   2017/10/17 19:23
 */

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String str = read.nextLine();
        String[] pieces = str.split("\\s+");
        for (int i = 0; i < pieces.length; ++i) {
            pieces[i] = change(pieces[i]);
        }
        String result = "";
        for (String s : pieces)
            result += " " + s;
        System.out.println(result.trim());
    }

    public static String change(String str) {
        if (str.length() > 1)
            return str.substring(0, 1).toUpperCase() + str.substring(1, str.length()).toLowerCase();
        else
            return str.toUpperCase();
    }

}
