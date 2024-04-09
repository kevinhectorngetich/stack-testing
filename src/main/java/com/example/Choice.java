// File: src/main/java/com/example/Choice.java
package com.example;

public class Choice<T> {
    private T value; 
    private boolean highPriority;

    public Choice(T value, boolean highPriority) {
        this.value = value;
        this.highPriority = highPriority;
    }

    public T getValue() {
        return value;
    }

    public boolean highPriority() { // Add this method! 
        return highPriority;
    }

}
