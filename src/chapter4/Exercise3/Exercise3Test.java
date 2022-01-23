package chapter4.Exercise3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Exercise3Test {
    public static int[] array;
    public static int[][] expectedResult;

    @BeforeAll
    public void BeforeAll() {
        array = new int[]{2, 11, 3, 9, 12, 15, 5, 14};
        expectedResult = new int[][]{new int[]{2, 15}, new int[]{3, 14}, new int[]{5, 12}, new int[]{9, 11}};
    }

    @Test
    void minimzePairTest() {
        final int[][] result = Exercise3.minimzePair(array);
        for (int i = 0; i < expectedResult.length; i++) {
            assertArrayEquals(expectedResult[i], result[i]);
        }

    }

}