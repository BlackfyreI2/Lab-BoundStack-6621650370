import java.util.NoSuchElementException;

public class BoundedStackTest {
    public static void main(String[] args) {
       
        testConstructor();
        testPushAndPeek();       
        testPopAndUnderflow();  
        testCopyProducer();      

        TestRunner.printSummary();
    }

    private static void testConstructor() {
        System.out.println("--- Test Constructor ---");
        BoundedStack<Integer> stack = new BoundedStack<>(5);
        TestRunner.assertEquals(5, stack.capacity(), "Capacity sets correctly");
        TestRunner.assertEquals(0, stack.size(), "Initial size is 0");
        TestRunner.assertTrue(stack.isEmpty(), "New stack is empty");
        TestRunner.assertThrows(IllegalArgumentException.class, () -> new BoundedStack<Integer>(0), "Capacity 0 throws Exception");
    }

    private static void testPushAndPeek() {
        System.out.println("\n--- Test Push & Peek ---");
        BoundedStack<String> stack = new BoundedStack<>(2);
        stack.push("A");
        TestRunner.assertEquals(1, stack.size(), "Size increases after push");
        TestRunner.assertEquals("A", stack.peek(), "Peek returns top element");
        
        stack.push("B");
        TestRunner.assertTrue(stack.isFull(), "Stack becomes full");
        TestRunner.assertThrows(IllegalStateException.class, () -> stack.push("C"), "Push on full stack throws Exception");
        TestRunner.assertThrows(IllegalArgumentException.class, () -> stack.push(null), "Push null throws Exception");
    }

    private static void testPopAndUnderflow() {
        System.out.println("\n--- Test Pop & Underflow ---");
        BoundedStack<Integer> stack = new BoundedStack<>(2);
        stack.push(10);
        stack.push(20);

        TestRunner.assertEquals(20, stack.pop(), "Pop returns last pushed item");
        TestRunner.assertEquals(10, stack.pop(), "Pop returns remaining item");
        TestRunner.assertTrue(stack.isEmpty(), "Stack is empty after pops");
        TestRunner.assertThrows(NoSuchElementException.class, stack::pop, "Pop on empty stack throws Exception");
    }

    private static void testCopyProducer() {
        System.out.println("\n--- Test Copy Producer ---");
        BoundedStack<String> original = new BoundedStack<>(3);
        original.push("X");
        
        BoundedStack<String> copy = original.copy();
        TestRunner.assertEquals(original.size(), copy.size(), "Copy has same size");
        
        copy.push("Y");
        TestRunner.assertEquals(1, original.size(), "Modifying copy does not affect original stack");
    }
}
