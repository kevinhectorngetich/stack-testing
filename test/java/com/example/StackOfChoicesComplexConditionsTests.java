// File: src/test/java/com/example/StackOfChoicesComplexConditionsTests.java
package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.example.StackOfChoicesComplexConditions;

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

    // ... your other tests ...

    @Test
    public void testPushWithPrimeAndNonPrimeNumbers() {
        StackOfChoicesComplexConditions stack = new StackOfChoicesComplexConditions();

        stack.push(2);
        stack.push(3);
        stack.push(4); // Non-prime 
        stack.push(5); 
        stack.push(9); // Non-prime

        assertEquals(5, stack.pop()); 
        assertEquals(3, stack.pop()); 
        assertEquals(2, stack.pop()); 
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testBoundaryCases() {
        StackOfChoicesComplexConditions stack = new StackOfChoicesComplexConditions();
        
        stack.push(-5);  // Should not be added
        stack.push(0);   // Should not be added 
        stack.push(1);   // Should not be added

        // ... (test a very large number)
        
        assertTrue(stack.isEmpty());
    }

}
