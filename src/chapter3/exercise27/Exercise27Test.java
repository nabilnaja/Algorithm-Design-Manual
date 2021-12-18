package chapter3.exercise27;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Exercise27Test {

    static List<int[]> sets;
    static List<Integer> sums;
    static List<int[]> expectedResult;

    @BeforeAll
    void setUp() {
        sets = Arrays.asList(new int[0], new int[]{3}, new int[]{3}, new int[]{1, 5, 7, 11, 24}, new int[]{1, 3, 9, 12}, new int[]{15, 4, 6, 2, 10}, new int[]{15, 4, 6, 2, 10}, new int[]{15, 9, 6, 2, 10});
        sums = Arrays.asList(2, 1, 3, 25, 4, 35, 37, 32);
        expectedResult = Arrays.asList(new int[0], new int[0], new int[]{3}, new int[]{1, 7, 11, 24}, new int[]{1, 3, 12}, new int[]{15, 4, 6, 10}, new int[]{15, 4, 6, 2, 10}, new int[]{15, 9, 6, 2});
    }

    @Test
    void findSumSubsetTest() {
        IntStream.range(0, sets.size()).forEach(i -> assertArrayEquals(expectedResult.get(i), Exercise27.findSumSubset(sets.get(i), sums.get(i))));
    }

}