// File: src/test/java/com/example/ChoiceOfStacksTest.java
package com.example;

import java.util.EmptyStackException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ChoiceOfStacksTests {

    @Test
    public void testPushAndPopInSingleContext() {
        ChoiceOfStacks<Integer> stack = new ChoiceOfStacks<>(); 
        stack.push(10);
        stack.push(20);

        assertEquals(20, stack.pop()); 
        assertEquals(10, stack.pop());  
    }

    @Test
    public void testContextSwitchingAndIsolation() {
        ChoiceOfStacks<Integer> stack = new ChoiceOfStacks<>(); 

        // Context "A" operations
        stack.push(10);
        stack.push(20);

        // Switch to context "B"
        stack.switchContext("contextB");

        // Verify isolation
        assertTrue(stack.isEmpty());

        stack.push(30);
        assertEquals(30, stack.pop());

        // Switch back to Context "A" 
        stack.switchContext("default"); 

        assertEquals(20, stack.pop()); 
        assertEquals(10, stack.pop());  
    }

    // ... your other tests ...

    @Test 
    public void testLIFOInvariant() {
        ChoiceOfStacks<String> stack = new ChoiceOfStacks<>();
        stack.push("apple");
        stack.push("banana");
        stack.push("orange");

        assertEquals("orange", stack.pop()); 
        assertEquals("banana", stack.pop()); 
        assertEquals("apple", stack.pop());  
    }

    @Test
    public void testContextIsolationInvariant() {
        ChoiceOfStacks<Integer> stack = new ChoiceOfStacks<>(); 

        stack.push(10);
        stack.push(20);

        stack.switchContext("B");

        assertTrue(stack.isEmpty()); // Context B is empty

        stack.switchContext("default"); // Back to the original context

        assertEquals(20, stack.pop()); 
        assertEquals(10, stack.pop());  
    }

    @Test
    public void testEmptyPopNegativeCase() {
        ChoiceOfStacks<Integer> stack = new ChoiceOfStacks<>();

        assertThrows(EmptyStackException.class, () -> stack.pop());
    }

    // ... Add more tests as needed for other invariants ...



}
