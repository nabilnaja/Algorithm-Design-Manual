package chapter3.exercise10;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Exercise10Test {
    public static List<String> words1;
    public static List<String> words2;
    public static List<Boolean> expectedResult;

    @BeforeAll
    void setUp() {
        words1 = Arrays.asList("nabil", "study", "march", "light", "moon", "grace", "");
        words2 = Arrays.asList("bilna", "tysdu", "armch", "lighp", "mon", "graces", "");
        expectedResult = Arrays.asList(true, true, true, false, false, false, true);
    }

    @Test
    void isBalancedStack() {
        IntStream.range(0, words1.size()).forEach(i -> assertEquals(expectedResult.get(i), Exercise10.areAnagrams(words1.get(i), words2.get(i))));
    }

}