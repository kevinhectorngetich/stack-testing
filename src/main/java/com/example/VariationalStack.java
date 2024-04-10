// File: src/main/java/com/example/VariationalStack.java 
package com.example;

public interface VariationalStack<T> extends Stack<T> {  
    T remove(int index); 
    boolean contains(T element);  
}
