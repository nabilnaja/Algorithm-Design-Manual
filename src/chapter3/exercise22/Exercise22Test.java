package chapter3.exercise22;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.util.stream.IntStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Exercise22Test {


    int[] expectedResult;
    int[] values;
    Exercise22 medianDt;

    @BeforeAll
    void setUp() {
        medianDt = new Exercise22();
        values = new int[]{5, 11, 15, 29, 20, 1, 119, 100, 50};
        expectedResult = new int[]{5, 8, 11, 13, 15, 13, 15, 17, 20};

    }

    @Test
    void populateDt() {
        IntStream.range(0, values.length).forEach(this::addValuesAndVerifyMedian);
    }

    private void addValuesAndVerifyMedian(int i) {
        medianDt.add(values[i]);
        assertEquals(expectedResult[i], medianDt.getMedian());
    }
}