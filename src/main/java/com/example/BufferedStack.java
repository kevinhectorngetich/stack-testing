// File: src/main/java/com/example/BufferedStack.java

package com.example;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BufferedStack<T> implements BulkStack<T> { 

    private ArrayDeque<T> underlyingStack;  // Holds the committed elements
    private List<T> buffer;            // Temporary storage for elements
    private int maxBufferSize;        // Maximum elements allowed in the buffer


    public BufferedStack(int maxBufferSize) {
        this.underlyingStack = new ArrayDeque<>();
        this.buffer = new ArrayList<>();
        this.maxBufferSize = maxBufferSize;
    }

    // ... other methods here
    public void push(T element) {
        if (buffer.size() < maxBufferSize) {
            buffer.add(element);
            if (buffer.size() == maxBufferSize) {
                commit(); // Auto-commit when the buffer is full
            }
        } else {
            // Handle buffer overflow (options below)
        }
    }

    public T pop() {
        if (!buffer.isEmpty()) {
            return buffer.remove(buffer.size() - 1); // Pop from the buffer
        } else {
            return underlyingStack.pop(); // Pop from the underlying stack
        }
    }

    public void commit() {
        underlyingStack.addAll(buffer);
        buffer.clear();
    }

    // You might also need ...
    public boolean isEmpty() {
        return buffer.isEmpty() && underlyingStack.isEmpty(); 
    } 

    // ... (rest of your BufferedStack class)

    @Override
    public void addAll(Collection<T> c) { // Exact match with the interface
        for (T element : c) {
            push(element); 
        }
    }
    

}
