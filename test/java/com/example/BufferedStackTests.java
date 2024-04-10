// File: src/test/java/com/example/BufferedStackTests.java


import com.example.BufferMode;
import com.example.BufferedStack;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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


    @Test
    public void testPeekBuffer() {
        BufferedStack<Integer> stack = new BufferedStack<>(3);
        stack.push(10); stack.push(20); 

        assertEquals(20, stack.peekBuffer()); 
        assertEquals(2, stack.getBufferSize());  // Access the size through the getter // Ensure  buffer is unchanged
 
    }

    @Test
    public void testBufferOnlyMode_PushException() {
        BufferedStack<Integer> stack = new BufferedStack<>(2);
        stack.setBufferMode(BufferMode.BUFFER_ONLY);
        stack.push(10); stack.push(20);  // Buffer is full

        assertThrows(IllegalStateException.class, () -> stack.push(30));
    }

    @Test
    public void testDirectAllowedMode() {
        BufferedStack<Integer> stack = new BufferedStack<>(3);
        stack.setBufferMode(BufferMode.DIRECT_ALLOWED);
        stack.push(10); 

        stack.push(20); // Direct push even with the non-empty buffer

        assertEquals(20, stack.pop()); 
        assertEquals(10, stack.pop()); 
}

// ... your existing tests ...

    @Test
    public void testBufferCapacityInvariant() {
        BufferedStack<Integer> stack = new BufferedStack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3); // Buffer is full

        assertThrows(IllegalStateException.class, () -> stack.push(4)); 
    }

    @Test
    public void testPopFromEmptyBufferedStack() {
        BufferedStack<Integer> stack = new BufferedStack<>(3);
        assertThrows(EmptyStackException.class, () -> stack.pop());
    }

    @Test
    public void testInvalidBufferSize() {
        assertThrows(IllegalArgumentException.class, () -> new BufferedStack<>(0)); 
    }

}
