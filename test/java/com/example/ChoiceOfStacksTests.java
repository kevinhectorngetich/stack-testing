// File: src/test/java/com/example/ChoiceOfStacksTest.java
package com.example;

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


}
