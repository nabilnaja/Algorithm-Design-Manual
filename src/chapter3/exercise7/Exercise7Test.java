package chapter3.exercise7;

import dt.Node;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Exercise7Test {

    static List<Node> sourceHead;
    static List<Node> expectedResultHead;

    @BeforeAll
    void setUp() {
        sourceHead = new ArrayList<>();
        expectedResultHead = new ArrayList<>();
        sourceHead.add(Node.buildList(new int[]{1, 2, 3, 4, 5, 6, 7}));
        sourceHead.add(Node.buildList(new int[]{1, 2}));
        sourceHead.add(Node.buildList(new int[]{1}));
        expectedResultHead.add(Node.buildList(new int[]{1, 2, 3, 4, 6, 7}));
        expectedResultHead.add(Node.buildList(new int[]{1, 2}));
        expectedResultHead.add(Node.buildList(new int[]{1}));
    }

    @Test
    public void deleteNode(){
        Node node = Node.getNodeAt(sourceHead.get(0), 4);
        assertNotNull(node);
        assertEquals(5, node.val);
        Exercise7.deleteNode(node);
        assertTrue(Node.compareLinkedList(expectedResultHead.get(0), sourceHead.get(0)));
    }

    @Test
    public void deleteNode2(){
        Node node = Node.getNodeAt(sourceHead.get(0), 1);
        assertNotNull(node);
        assertEquals(2, node.val);
        Exercise7.deleteNode(node);
        assertTrue(Node.compareLinkedList(expectedResultHead.get(1), sourceHead.get(1)));
    }

    @Test
    public void deleteNode3(){
        Node node = Node.getNodeAt(sourceHead.get(2), 0);
        assertNotNull(node);
        assertEquals(1, node.val);
        Exercise7.deleteNode(node);
        assertTrue(Node.compareLinkedList(expectedResultHead.get(2), sourceHead.get(2)));
    }
}