package chapter4.exercise7;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Exercise7Test {
    public static int[] hIndex;
    public static int expectedResult;

    @BeforeAll
    public void BeforeAll() {
        hIndex = new int[]{3, 0, 6, 1, 5};
        expectedResult = 3;
    }

    @Test
    void minimzePairTest() {
        final int result = Exercise7.hIndex(hIndex);
        assertEquals(expectedResult, result);


    }

}