package main;

import java.util.*;

/**
 * @author RiverLea
 * @version 1.0
 * @since JDK 1.8
 * Date   2017/9/14 15:57
 */

public class First {

    public static Map<Integer, String> result = new HashMap<>();
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        List<String> inputs = new LinkedList<>();
        String temp;

        while(!(temp = read.nextLine()).equals("")) {
            inputs.add(temp);
        }

        int index = 0;
    }

    public static void timeMinus(String front, String later, int index) {
        String[] fronts = front.split(" ");
        String[] laters = later.split(" ");
        if(!fronts[1].split(":")[2].equals("00") || !laters[1].split(":")[2].equals("00")){
            result.put(index, "incorrect data");
        }
        String[] frontTime = fronts[1].split(":");
        String[] laterTime = laters[1].split(":");


    }
}
