package chapter4.exercise13;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Exercise13Test {
    public static int[] in;
    public static int[] out;
    public static int expectedResult;

    @BeforeAll
    public void BeforeAll() {
        in = new int[]{2, 11, 3, 9, 12, 15, 5, 14, 12};
        out = new int[]{5, 12, 5, 19, 16, 16, 6, 16, 20};
        expectedResult = 5;
    }

    @Test
    void minimzePairTest() {
        final int result = Exercise13.getMaxPresence(in, out);
        assertEquals(expectedResult, result);

    }

}