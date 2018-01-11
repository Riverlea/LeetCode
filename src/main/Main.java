package main;

import java.util.*;

/**
 * @author RiverLea
 * @version 1.0
 * @since JDK 1.8
 */

class Node {
    String value;
    Node next;
}

public class Main {

    public static Map<Integer, String> result = new HashMap<>();

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        List<String> inputs = new LinkedList<>();
        String temp;
        while(!(temp = read.nextLine()).equals("")) {
            inputs.add(temp);
        }

        int index = 0;
        //System.out.println(inputs);
        for (String input : inputs) {
            String[] str = input.split(";");

        }
    }

    public static void Analyse(String str, int index) {
        String[] part = str.split(",");
        if (part[0].equals("0")){
            result.put(index, "incorrect ");
            return ;
        }
    }
}
