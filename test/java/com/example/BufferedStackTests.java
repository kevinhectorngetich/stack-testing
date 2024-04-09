// File: src/test/java/com/example/BufferedStackTests.java


import java.util.ArrayList;
import java.util.List; // For using List<Integer>
import com.example.BufferedStack; 
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class BufferedStackTests {

    @Test
    public void testPushAndCommit() {
        BufferedStack<Integer> stack = new BufferedStack<>(3); 
        stack.push(1); stack.push(2); stack.push(3); // Buffer becomes full, auto-commit
        
        assertEquals(3, stack.pop()); 
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testAddAll() {
        BufferedStack<Integer> stack = new BufferedStack<>(5);
        List<Integer> myList = Arrays.asList(1, 2, 3, 4);
        stack.addAll(myList);       


        
        assertEquals(4, stack.pop());
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());
    }
}
