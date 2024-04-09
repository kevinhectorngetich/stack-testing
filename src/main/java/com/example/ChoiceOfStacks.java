
// File: src/main/java/ChoiceOfStacks.java
package com.example;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class ChoiceOfStacks<T> implements Stack<T> {
    private Map<String, ArrayDeque<T>> stacks; 

    private String currentContext;   

    public ChoiceOfStacks() {
        stacks = new HashMap<>();
        currentContext = "default"; // Start with a default context
    }

    // Choose a stack based on the current context
    @SuppressWarnings("unchecked") // Trust that ArrayDeque is the correct Stack
    private Stack<T> getCurrentStack() {
        return (Stack<T>) stacks.computeIfAbsent(currentContext, k -> new ArrayDeque<T>()); 
    }
    
    
    @Override
    public void push(T element) {
        getCurrentStack().push(element); 
    }

    @Override
    public T pop() {
        return getCurrentStack().pop();
    }

    @Override
    public boolean isEmpty() {
        return getCurrentStack().isEmpty();
    }

    // Additional helper (for testing and potentially for real usage)
    public void switchContext(String newContext) {
        currentContext = newContext;
    }
}
