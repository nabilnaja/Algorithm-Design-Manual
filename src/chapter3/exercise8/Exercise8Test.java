package chapter3.exercise8;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Exercise8Test {

    Exercise8 exercise8;
    static List<int[][]> moves;
    static List<String[]> expectedResult;

    @BeforeAll
    void setUp() {
        exercise8 = new Exercise8();
        moves = new ArrayList<>();
        expectedResult = new ArrayList<>();

        moves.add(new int[][]{{0, 0}, {2, 0}, {1, 1}, {2, 1}, {2, 2}});
        expectedResult.add(new String[]{"Pending", "Pending", "Pending", "Pending", "A"});

        moves.add(new int[][]{{0, 0}, {2, 0}, {0, 1}, {2, 1}, {0, 2}});
        expectedResult.add(new String[]{"Pending", "Pending", "Pending", "Pending", "A"});

        moves.add(new int[][]{{0, 0}, {2, 0}, {0, 1}, {1, 1}, {1, 2}, {0, 2}});
        expectedResult.add(new String[]{"Pending", "Pending", "Pending", "Pending", "Pending", "B"});

        moves.add(new int[][]{{0, 0}, {1, 0}, {0, 1}, {1, 1}, {1, 2}, {0, 2}, {2, 2}, {2, 1}, {2, 0}});
        expectedResult.add(new String[]{"Pending", "Pending", "Pending", "Pending", "Pending", "Pending", "Pending", "Pending", "Draw"});

    }

    @Test
    public void playGame() {
        IntStream.range(0, moves.size()).forEach(i -> {
            IntStream.range(0, moves.get(i).length).forEach(j -> assertEquals(expectedResult.get(i)[j] ,exercise8.makeMove(moves.get(i)[j])));
            exercise8.initialize();
        });
    }
}