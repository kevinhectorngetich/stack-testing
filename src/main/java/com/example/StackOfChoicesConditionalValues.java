// File: src/main/java/com/example/StackOfChoicesConditionalValues.java
package com.example;

import java.util.ArrayDeque;

public class StackOfChoicesConditionalValues implements Stack<Choice<Integer>> { 
    private ArrayDeque<Choice<Integer>> stack;

    public StackOfChoicesConditionalValues() {
        stack = new ArrayDeque<>();
    }

    @Override
    public void push(Choice<Integer> choice) {
        if (choice.highPriority()) {
            stack.push(choice);
        } 
    }

    @Override
    public Choice<Integer> pop() {
        return stack.pop();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
