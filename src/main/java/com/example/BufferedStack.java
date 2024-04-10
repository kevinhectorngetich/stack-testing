// File: src/main/java/com/example/BufferedStack.java

package com.example;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *  A BufferedStack implementation that provides a holding area (buffer) 
 *  before elements are committed to the underlying stack. It supports 
 *  context switching (Buffer-only mode vs. Direct Access) and a peekBuffer() method.
 */ 
public class BufferedStack<T> implements BulkStack<T> { 

    private ArrayDeque<T> underlyingStack;  // Holds the committed elements
    private List<T> buffer;            // Temporary storage for elements
    private int maxBufferSize;        // Maximum elements allowed in the buffer
    private BufferMode mode = BufferMode.DIRECT_ALLOWED; // Default behavior 

    public BufferedStack(int maxBufferSize) {
        this.underlyingStack = new ArrayDeque<>();
        this.buffer = new ArrayList<>();
        this.maxBufferSize = maxBufferSize;
    }

    // ... other methods ...

    /**
     * Adds an element to the buffer. If the buffer is full, auto-commits to the underlying stack.
     */
    // Modified push and pop to handle Direct Operations After Buffering
    public void push(T element) {
        if (mode == BufferMode.BUFFER_ONLY && !buffer.isEmpty()) {
            throw new IllegalStateException("Direct push not allowed in BUFFER_ONLY mode"); 
        } else {
            if (buffer.size() < maxBufferSize) {
                buffer.add(element);
                if (buffer.size() == maxBufferSize) {
                    commit(); 
                }
            } else {
                underlyingStack.push(element); 
            }
        }
    }

    /**
     * Pops an element from the buffer if not empty, otherwise from the underlying stack.
     * Throws an exception if a direct pop is attempted in BUFFER_ONLY mode.
     */
    public T pop() {
        if (mode == BufferMode.BUFFER_ONLY && !buffer.isEmpty()) {
            throw new IllegalStateException("Direct pop not allowed in BUFFER_ONLY mode"); 
        } else {
            if (!buffer.isEmpty()) {
                return buffer.remove(buffer.size() - 1); 
            } else {
                return underlyingStack.pop(); 
            }
        }
    }

    /**
     * Commits all elements from the buffer to the underlying stack.
     */
    public void commit() {
        underlyingStack.addAll(buffer);
        buffer.clear();
    }

    // You might also need ...
    public boolean isEmpty() {
        return buffer.isEmpty() && underlyingStack.isEmpty(); 
    } 

    @Override
    public void addAll(Collection<T> c) { 
        for (T element : c) {
            push(element); 
        }
    }

    /**
     * Returns the top element of the buffer without removing it, or null if the buffer is empty.
     */
    // To handle Context Change Handling scenario
    public T peekBuffer() {
        if (buffer.isEmpty()) {
            return null; 
        } else {
            return buffer.get(buffer.size() - 1); 
        }
    }

    /**
     * Sets the operating mode of the BufferedStack.
     */
    public void setBufferMode(BufferMode mode) {
        this.mode = mode;
    }
        // ... (rest of your BufferedStack class) ... 
    public int getBufferSize() {
        return buffer.size();
    }





}
