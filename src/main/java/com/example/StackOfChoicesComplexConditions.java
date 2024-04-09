// File: src/main/java/com/example/StackOfChoicesComplexConditions.java
package com.example; 

import java.util.ArrayDeque;

public class StackOfChoicesComplexConditions implements Stack<Integer> {
    private ArrayDeque<Integer> stack;

    public StackOfChoicesComplexConditions() {
        stack = new ArrayDeque<>();
    }

    @Override
    public void push(Integer element) {
        if (isPrime(element)) {
            stack.push(element);
        }
    }

    @Override
    public Integer pop() {
        return stack.pop();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // Helper method to determine if a number is prime
    private boolean isPrime(int number) { 
        if (number <= 1) {
            return false;
        }

        // Check from 2 to the square root of the number 
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
