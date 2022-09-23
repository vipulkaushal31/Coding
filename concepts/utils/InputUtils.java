package concepts.utils;

public class InputUtils {
    private static final int[] testArray = { 45, 7, 3, 121, 12, 2 };
    private static final int[] testNegativeArray = { 45, -7, 3, -121, 12, -2, 19, -34, 56 };

    public static int[] inputTestArray() {
        return testArray;
    }

    public static int[] inputTestNegArray() {
        return testNegativeArray;
    }
}
