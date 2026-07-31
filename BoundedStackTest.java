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
}
