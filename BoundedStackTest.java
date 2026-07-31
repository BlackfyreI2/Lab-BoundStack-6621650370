public class BoundedStackTest {
    public static void main(String[] args) {
        testConstructor();
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
}
