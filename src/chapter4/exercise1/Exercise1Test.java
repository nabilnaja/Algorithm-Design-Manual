package chapter4.exercise1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Exercise1Test {
    public static List<Integer> ratings;
    public static List<Integer> result;
    public static Exercise1 solution;

    @BeforeAll
    public void BeforeAll(){
        ratings = Arrays.asList(2,6,1,9,44,83,11,19,12,25,65);
        result = ratings.stream().sorted().toList();
        solution = new Exercise1();
    }
    @Test
    void testSort() {
        final List<Exercise1.Player> playersSorted = solution.mergeSort(ratings);
        IntStream.range(0, result.size()).forEach(index -> assertEquals(result.get(index), playersSorted.get(index).rating));
    }

}