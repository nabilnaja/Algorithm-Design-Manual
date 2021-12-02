package chapter3.exercise24;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Exercise24Test {

    static List<int[]> arrays;
    static List<Integer> ks;
    static List<Boolean> expectedResults;

    @BeforeAll
    void setUp() {
        arrays = new ArrayList<>();
        ks = new ArrayList<>();
        expectedResults = new ArrayList<>();

        arrays.add(new int[]{4,3,2,1,6});
        arrays.add(new int[]{99,3,2,1,99});
        arrays.add(new int[]{4,3,2,99,6,33,21,12,99});
        arrays.add(new int[]{4,3,2,5,6,33,21,12,1});
        arrays.add(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,99,14,15,16,99,18,19,20});
        arrays.add(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,99,14,99,16,17,18,19,20});
        arrays.add(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,99,99,15,16,17,18,19,20});
        arrays.add(new int[0]);

        ks.add(8);
        ks.add(8);
        ks.add(7);
        ks.add(4);
        ks.add(3);
        ks.add(3);
        ks.add(2);
        ks.add(5);

        expectedResults.add(false);
        expectedResults.add(true);
        expectedResults.add(true);
        expectedResults.add(false);
        expectedResults.add(false);
        expectedResults.add(true);
        expectedResults.add(true);
        expectedResults.add(false);
    }

    @Test
    void findWordByPrefix_1() {
        IntStream.range(0, arrays.size()).forEach(i -> {
            //System.out.println(i);
            assertEquals(expectedResults.get(i) ,Exercise24.containsNearbyAlmostDuplicate(arrays.get(i), ks.get(i)));
        });
   }

}