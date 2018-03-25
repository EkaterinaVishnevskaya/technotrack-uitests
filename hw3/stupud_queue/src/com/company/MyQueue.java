package com.company;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> leftStack = new Stack<>();
    Stack<Integer> rightStack = new Stack<>();

    Integer push (Integer e) {
        return leftStack.push(e);
    }

    Integer pop () {
        if (!rightStack.empty()){
            return rightStack.pop();
        } else
        {
            while (!leftStack.empty()){
                rightStack.push(leftStack.pop());
            }
            return rightStack.pop();
        }
    }
}
