package com.company;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("dfsdgfd");
        list.add("fdsgfdgfdgfdgfdg");
        Predicate<String> predicate = s -> (s.length()>=3)&&(s.length()<=10);
        list.forEach((String s)->{if (predicate.test(s)) {System.out.println();}});
    }
}
