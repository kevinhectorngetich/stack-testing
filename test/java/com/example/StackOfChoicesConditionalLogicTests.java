// File: src/test/java/com/example/StackOfChoicesConditionalLogicTests.java
package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackOfChoicesConditionalLogicTests {

    @Test
    public void testPushEvenAndOdd() {
        StackOfChoicesConditionalLogic stack = new StackOfChoicesConditionalLogic();
        stack.push(4); // Should get pushed
        stack.push(3); // Should not get pushed

        assertEquals(4, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testMultipleEvenValues() {
        StackOfChoicesConditionalLogic stack = new StackOfChoicesConditionalLogic();
        stack.push(10);
        stack.push(2); 
        stack.push(8);

        assertEquals(8, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(10, stack.pop()); 
        assertTrue(stack.isEmpty());
    }

    // You can add more tests here!
}
