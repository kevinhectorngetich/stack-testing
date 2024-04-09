// File: src/test/java/com/example/StackOfChoicesComplexConditionsTests.java
package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackOfChoicesComplexConditionsTests {

    @Test
    public void testStackWithPrimeNumbers() {
        StackOfChoicesComplexConditions stack = new StackOfChoicesComplexConditions();

        stack.push(4);  // Not prime, should not be added
        stack.push(11); // Prime, should be added
        stack.push(15); // Not prime, should not be added
        
        assertEquals(11, stack.pop()); 
        assertTrue(stack.isEmpty());
    }

    // ... Add more tests here
}
