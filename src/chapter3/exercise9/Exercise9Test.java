package chapter3.exercise9;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Exercise9Test {

    static List<List<String>> expectedResult;
    static List<String> words;
    static List<String> queries;

    @BeforeAll
    void setUp() {
        expectedResult = new ArrayList<>();
        queries = new ArrayList<>();
        words = readWordsFromFile("src/chapter3/exercise9/words_alpha.txt");
        queries.add("269");
        expectedResult.add(Arrays.asList("amy", "any", "boy", "bow", "box", "coy", "cow", "cox", "coz"));
    }

    @Test
    public void words() {
        List<String> result = Exercise9.phoneKeyToWord(queries.get(0), words);
        assertEquals(expectedResult.get(0).size(), result.size());
        IntStream.range(0, result.size()).forEach(i -> assertEquals(expectedResult.get(0).get(i), result.get(i)));
    }


    private static List<String> readWordsFromFile(String filename) {
        List<String> words;
        try {
            words = Files.readAllLines(Paths.get(filename));
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
        return words;
    }
}