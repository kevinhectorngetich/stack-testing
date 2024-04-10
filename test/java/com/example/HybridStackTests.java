// File: src/test/java/com/example/HybridStackTests.java
package com.example;

import java.util.EmptyStackException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HybridStackTests {
    @Test
    public void testClassicModePushAndPop() {
        HybridStack<Integer> stack = new HybridStack<>();
        stack.push(10);
        stack.push(20);

        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());
        assertTrue(stack.isEmpty());

        stack.setMode(StackMode.VARIATIONAL);  // Switch modes
        stack.push(30);
    }

    @Test
    public void testVariationalPop() {
        HybridStack<Integer> stack = new HybridStack<>();
        stack.setMode(StackMode.VARIATIONAL);
        stack.push(10);
        stack.push(20);
        stack.push(30);
    
        assertEquals(30, stack.pop()); // Pop from the end
        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());
        assertTrue(stack.isEmpty());
    }

    // Remove Variational Stack
    // ... your existing HybridStackTests class ...

    // VariationalStack Methods and Mode Restrictions
    @Test
    public void testRemoveByIndex() {
        HybridStack<String> stack = new HybridStack<>();
        stack.setMode(StackMode.VARIATIONAL);
        stack.push("apple");
        stack.push("banana");
        stack.push("orange");

        assertEquals("banana", stack.remove(1));
        assertEquals(2, stack.size()); // Verify the size is reduced
    }

    @Test
    public void testContains() {
        HybridStack<Integer> stack = new HybridStack<>();
        stack.setMode(StackMode.VARIATIONAL);
        stack.push(5);
        stack.push(10);

        assertTrue(stack.contains(10));
        assertFalse(stack.contains(20));
    }

    @Test
    public void testVariationalMethodsInClassicMode() {
        HybridStack<Integer> stack = new HybridStack<>();  // Default is CLASSIC mode
        stack.push(10);

        assertThrows(IllegalStateException.class, () -> stack.remove(0));
        assertThrows(IllegalStateException.class, () -> stack.contains(10));
    }

    // Mode Switching
    @Test
    public void testPopBehaviorChangesWithModeSwitch() {
        HybridStack<Integer> stack = new HybridStack<>();
        stack.push(10);  
        stack.push(20); 
        stack.setMode(StackMode.VARIATIONAL); 
        stack.push(30);

        assertEquals(30, stack.pop()); // VARIATIONAL pop (from the end)
        assertEquals(20, stack.pop()); // VARIATIONAL pop 
        assertEquals(10, stack.pop()); // CLASSIC pop (since mode changes implicitly)
    }


        @Test
    public void testRemoveByIndexMidModeSwitch() {
        HybridStack<String> stack = new HybridStack<>();
        stack.setMode(StackMode.VARIATIONAL);
        stack.push("apple"); 
        stack.push("banana"); 
        stack.push("orange");

        stack.setMode(StackMode.CLASSIC); // Switch mid-test
        assertThrows(IllegalStateException.class, () -> stack.remove(1)); 
    }

    @Test
    public void testDataIntegrityAfterModeSwitch() {
        HybridStack<Integer> stack = new HybridStack<>();
        stack.push(10);
        stack.push(20); 

        stack.setMode(StackMode.VARIATIONAL); 
        stack.push(30);

        stack.setMode(StackMode.CLASSIC); 
        assertEquals(20, stack.pop()); // Verify order was preserved
        assertEquals(10, stack.pop());
    }

    // negative cases and invariants
    // ... your existing tests ...

    @Test
    public void testEmptyPopInClassicMode() {
        HybridStack<Integer> stack = new HybridStack<>(); 
        assertThrows(EmptyStackException.class, () -> stack.pop());
    }

    @Test
    public void testEmptyPopInVariationalMode() {
        HybridStack<Integer> stack = new HybridStack<>(); 
        stack.setMode(StackMode.VARIATIONAL);
        assertThrows(EmptyStackException.class, () -> stack.pop()); 
    }

}
