// File: src/main/java/com/example/StackOfChoicesConditionalLogic.java
package com.example;

import java.util.ArrayDeque;

public class StackOfChoicesConditionalLogic implements Stack<Integer> { // For integers only
    private ArrayDeque<Integer> stack;

    public StackOfChoicesConditionalLogic() {
        stack = new ArrayDeque<>();
    }

    @Override
    public void push(Integer element) { // Notice the argument is now 'Integer'
        if (isEven(element)) {  
            stack.push(element);
        } 
    } 

    @Override
    public Integer pop() { // Return type is now 'Integer'
        return stack.pop();
    }
    
    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // Helper for now, assuming elements are integers
    private boolean isEven(Integer number) {
        return number % 2 == 0; 
    }
}
