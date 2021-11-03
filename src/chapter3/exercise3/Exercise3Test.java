package chapter3.exercise3;

import dt.Node;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Exercise3Test {

    static List<Node> sourceHead;
    static List<Node> expectedResultHead;

    @BeforeAll
    public void BeforeAll() {
        sourceHead = new ArrayList<>();
        expectedResultHead = new ArrayList<>();
        sourceHead.add(Node.buildList(new int[]{1, 2, 3, 4, 5, 6, 7}));
        sourceHead.add(Node.buildList(new int[]{1, 2}));
        sourceHead.add(Node.buildList(new int[]{1}));
        expectedResultHead.add(Node.buildList(new int[]{7, 6, 5, 4, 3, 2, 1}));
        expectedResultHead.add(Node.buildList(new int[]{2, 1}));
        expectedResultHead.add(Node.buildList(new int[]{1}));
    }

    @Test
    public void reverseLinkedList(){
        IntStream.range(0, expectedResultHead.size()).forEach(i -> {
            Node reversedLinkedList = Exercise3.reverseLinkedList(sourceHead.get(i));
            assertTrue(Node.compareLinkedList(expectedResultHead.get(i), reversedLinkedList));
        });
    }

}