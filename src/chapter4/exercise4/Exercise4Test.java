package chapter4.exercise4;

import chapter4.Exercise3.Exercise3;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Exercise4Test {
    public static List<Item> sortedByNumberArray;
    public static List<Item>  expectedResult;

    @BeforeAll
    public void BeforeAll() {
        sortedByNumberArray = new ArrayList<>();
        sortedByNumberArray.add(new Item(0, Exercise4.YELLOW));
        sortedByNumberArray.add(new Item(1, Exercise4.YELLOW));
        sortedByNumberArray.add(new Item(2, Exercise4.BLUE));
        sortedByNumberArray.add(new Item(3, Exercise4.RED));
        sortedByNumberArray.add(new Item(4, Exercise4.BLUE));
        sortedByNumberArray.add(new Item(5, Exercise4.BLUE));
        sortedByNumberArray.add(new Item(6, Exercise4.YELLOW));
        sortedByNumberArray.add(new Item(7, Exercise4.RED));
        sortedByNumberArray.add(new Item(8, Exercise4.RED));
        expectedResult = new ArrayList<>();
        expectedResult.add(new Item(3, Exercise4.RED));
        expectedResult.add(new Item(7, Exercise4.RED));
        expectedResult.add(new Item(8, Exercise4.RED));
        expectedResult.add(new Item(2, Exercise4.BLUE));
        expectedResult.add(new Item(4, Exercise4.BLUE));
        expectedResult.add(new Item(5, Exercise4.BLUE));
        expectedResult.add(new Item(0, Exercise4.YELLOW));
        expectedResult.add(new Item(1, Exercise4.YELLOW));
        expectedResult.add(new Item(6, Exercise4.YELLOW));
    }

    @Test
    void minimzePairTest() {
        final List<Item> result = Exercise4.sortByColor(sortedByNumberArray);
        for (int i = 0; i < expectedResult.size(); i++) {
            assertEquals(expectedResult.get(i), result.get(i));
        }

    }

}