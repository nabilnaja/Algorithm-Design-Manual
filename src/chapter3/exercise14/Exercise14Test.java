package chapter3.exercise14;

import dt.DoubleLinkedListNode;
import dt.TreeNode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Exercise14Test {

    TreeNode firstTree;
    TreeNode secondTree;
    TreeNode thirdTree;
    int[] expectedResult1;
    int[] expectedResult2;
    int size1 = 10;
    int size2 = 5;

    @BeforeAll
    void setUp() {
        final int[] arr = IntStream.iterate(0, i -> i + 2).limit(size1).toArray();
        firstTree = TreeNode.sortedArrayToBST(arr, 0, size1 - 1);
        final int[] arr1 = IntStream.iterate(1, i -> i + 2).limit(size1).toArray();
        secondTree = TreeNode.sortedArrayToBST(arr1, 0, size1 - 1);
        final int[] arr2 = IntStream.iterate(1, i -> i + 2).limit(size2).toArray();
        thirdTree = TreeNode.sortedArrayToBST(arr2, 0, size2 - 1);
        expectedResult1 = IntStream.concat(Arrays.stream(arr), Arrays.stream(arr1)).sorted().toArray();
        expectedResult2= IntStream.concat(Arrays.stream(arr), Arrays.stream(arr2)).sorted().toArray();
    }

    @Test
    void toLinkedList_1() {
        final DoubleLinkedListNode first = Exercise14.toLinkedList(firstTree);
        final DoubleLinkedListNode second = Exercise14.toLinkedList(secondTree);
        final DoubleLinkedListNode result = Exercise14.mergeLinkedList(first, second);
        compareResult(result, expectedResult1);
    }

    @Test
    void toLinkedList_2() {
        final DoubleLinkedListNode first = Exercise14.toLinkedList(firstTree);
        final DoubleLinkedListNode third = Exercise14.toLinkedList(thirdTree);
        final DoubleLinkedListNode result = Exercise14.mergeLinkedList(first, third);
        compareResult(result, expectedResult2);
    }

    void compareResult(DoubleLinkedListNode root, int[] result) {
        DoubleLinkedListNode head = root;
        for (int j : result) {
            assertEquals(j, head.val);
            head = head.next;
        }
        assertNull(head);
    }
}