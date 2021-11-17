package chapter3.exercise11;

import chapter3.exercise10.Exercise10;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Exercise11Test {

    public static Exercise11 exercise11;
    public static int[] presentNumbers;
    public static int[] absentNumbers;
    public static int setSize = 200;

    @BeforeAll
    void setUp() {
        exercise11 = new Exercise11(setSize);
        presentNumbers = new int[]{5, 13, 43, 22, 95, 200, 180, 175};
        absentNumbers = new int[]{9, 10, 33, 2, 80, 199, 116, 174};
    }

    @Test
    void isBalancedStack() {
        assertEquals(setSize, exercise11.dictionary.length);
        IntStream.range(0, presentNumbers.length).forEach(i -> exercise11.insert(presentNumbers[i]));
        IntStream.range(0, presentNumbers.length).forEach(i -> assertEquals(presentNumbers[i], exercise11.search(presentNumbers[i])));
        IntStream.range(0, absentNumbers.length).forEach(i -> assertNotEquals(absentNumbers[i], exercise11.search(absentNumbers[i])));
        IntStream.range(0, absentNumbers.length).forEach(i -> assertEquals(0, exercise11.search(absentNumbers[i])));
        IntStream.range(0, presentNumbers.length).forEach(i -> exercise11.delete(presentNumbers[i]));
        IntStream.range(0, presentNumbers.length).forEach(i -> assertEquals(0, exercise11.search(presentNumbers[i])));
    }
}