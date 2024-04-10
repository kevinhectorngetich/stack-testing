// File: src/main/java/com/example/HybridStack.java 
package com.example;

import java.util.ArrayDeque;
import java.util.Deque; // More general interface for better flexibility
import java.util.LinkedList; 
import java.util.EmptyStackException;

public class HybridStack<T> implements Stack<T>, VariationalStack<T> {

    private StackMode mode = StackMode.CLASSIC; 
    private Deque<T> classicStack = new ArrayDeque<>(); 
    private LinkedList<T> variationalStack = new LinkedList<>();

    // Implement methods from both interfaces here 
    public void push(T element) {
        if (mode == StackMode.CLASSIC) {
            classicStack.addFirst(element); 
        } else { // Variational Mode
            variationalStack.addLast(element);  
        }
    }
    
    public T pop() {
        if (mode == StackMode.CLASSIC) {
            if (classicStack.isEmpty()) {  
                throw new EmptyStackException(); 
            }
            return classicStack.removeFirst(); 
        } else { // Variational Mode
            if (variationalStack.isEmpty()) { 
                throw new EmptyStackException(); 
            }
            return variationalStack.removeLast();  
        }
    }
    
    public boolean isEmpty() {
        if (mode == StackMode.CLASSIC) {
            return classicStack.isEmpty();
        }  else {
             return variationalStack.isEmpty();  
        }
    }
    
    @Override
    public T remove(int index) {
        if (mode != StackMode.VARIATIONAL) {
            throw new IllegalStateException("Not in Variational mode"); 
        }
        return variationalStack.remove(index); // Access the variationalStack
    }
    
    @Override
    public boolean contains(T element) {
        if (mode != StackMode.VARIATIONAL) {
            throw new IllegalStateException("Not in Variational mode"); 
        }
        return variationalStack.contains(element); // Access the variationalStack
    }
    
    public int size() {
        if (mode == StackMode.CLASSIC) {
            return classicStack.size();
        }  else { 
            return variationalStack.size(); 
        }
    }
    

    public void setMode(StackMode newMode) {
        if (mode == newMode) { return; } // No change needed
    
        if (newMode == StackMode.CLASSIC) {
            while (!variationalStack.isEmpty()) {
                classicStack.addFirst(variationalStack.removeLast());
            }
        } else { // Switching to VARIATIONAL 
            while (!classicStack.isEmpty()) {
                variationalStack.addLast(classicStack.removeFirst());
            }
        }
        mode = newMode;
    }
    
    

}
