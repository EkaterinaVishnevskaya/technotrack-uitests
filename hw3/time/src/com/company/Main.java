package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        long starttime = System.currentTimeMillis();
        for (int i = 0; i<1000000; i++) {
            linkedList.add(new Integer(i));
        }
        long endtime = System.currentTimeMillis();
        System.out.println(endtime-starttime);
        starttime = System.currentTimeMillis();
        for (int i = 0; i<1000000; i++) {
            arrayList.add(new Integer(i));
        }
        endtime = System.currentTimeMillis();
        System.out.println(endtime-starttime);
        starttime = System.currentTimeMillis();
        for (int i = 0; i<1000000; i++) {
            stack.add(new Integer(i));
        }
        endtime = System.currentTimeMillis();
        System.out.println(endtime-starttime);
    }
}
