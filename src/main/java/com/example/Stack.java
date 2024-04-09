// File: src/main/java/Stack.java
package com.example;

public interface Stack<T> { // Use generics for flexibility 
    void push(T element);
    T pop();
    boolean isEmpty();

    
}
