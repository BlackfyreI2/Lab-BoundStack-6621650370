import java.util.Objects;

public class TestRunner {
    private static int total = 0;
    private static int passed = 0;
    private static int failed = 0;

    public static void assertEquals(Object expected, Object actual, String testName) {
        total++;
        if (Objects.equals(expected, actual)) {
            passed++;
            System.out.println("  [PASS] " + testName);
        } else {
            failed++;
            System.err.println("  [FAIL] " + testName + " -> Expected: " + expected + ", Actual: " + actual);
        }
    }

    public static void assertTrue(boolean condition, String testName) {
        assertEquals(true, condition, testName);
    }

    public static void assertFalse(boolean condition, String testName) {
        assertEquals(false, condition, testName);
    }

    public static void assertThrows(Class<? extends Exception> expectedException, Runnable executable, String testName) {
        total++;
        try {
            executable.run();
            failed++;
            System.err.println("  [FAIL] " + testName + " -> Expected exception: " + expectedException.getName() + " but none was thrown.");
        } catch (Exception e) {
            if (expectedException.isInstance(e)) {
                passed++;
                System.out.println("  [PASS] " + testName);
            } else {
                failed++;
                System.err.println("  [FAIL] " + testName + " -> Expected: " + expectedException.getName() + ", Got: " + e.getClass().getName());
            }
        }
    }

    public static void printSummary() {
        System.out.println("\nTEST SUMMARY: Total: " + total + " | Passed: " + passed + " | Failed: " + failed);
    }
}
