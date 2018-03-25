package com.company;

import java.util.ArrayList;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> tourists = new ArrayList<>();
        tourists.add("Lana");
        tourists.add("Mary");
        tourists.add("Kaetlyn");
        tourists.add("Mary");
        HashSet tourists_names = new HashSet(tourists);
        tourists.removeAll(tourists_names);

    }
}
