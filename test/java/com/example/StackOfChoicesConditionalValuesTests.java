// File: src/test/java/com/example/StackOfChoicesConditionalValuesTests.java
package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackOfChoicesConditionalValuesTests {

    @Test
    public void testStackWithPriorityChoices() {
        StackOfChoicesConditionalValues stack = new StackOfChoicesConditionalValues(); 
        
        stack.push(new Choice<>(5, false));  // Should not get pushed
        stack.push(new Choice<>(9, true));   // Should get pushed

        assertEquals(9, ((Choice<Integer>) stack.pop()).getValue()); 
        assertTrue(stack.isEmpty()); 
    }

    // More test cases below...
}
