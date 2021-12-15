package chapter3.exercise14;

import dt.DoubleLinkedListNode;
import dt.TreeNode;
import dt.TreeNodeHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Exercise14Test {

    TreeNodeHelper<Integer> treeNodeHelper = new TreeNodeHelper<>();

    TreeNode<Integer> firstTree;
    TreeNode<Integer> secondTree;
    TreeNode<Integer> thirdTree;
    Integer[] expectedResult1;
    Integer[] expectedResult2;
    int size1 = 10;
    int size2 = 5;

    @BeforeAll
    void setUp() {
        final Integer[] arr = IntStream.iterate(0, i -> i + 2).limit(size1).boxed().toArray(Integer[]::new);
        firstTree = treeNodeHelper.sortedArrayToBST(arr, 0, size1 - 1);
        final Integer[] arr1 = IntStream.iterate(1, i -> i + 2).limit(size1).boxed().toArray(Integer[]::new);
        secondTree = treeNodeHelper.sortedArrayToBST(arr1, 0, size1 - 1);
        final Integer[] arr2 = IntStream.iterate(1, i -> i + 2).limit(size2).boxed().toArray(Integer[]::new);
        thirdTree = treeNodeHelper.sortedArrayToBST(arr2, 0, size2 - 1);
        expectedResult1 = Stream.concat(Arrays.stream(arr), Arrays.stream(arr1)).sorted().toArray(Integer[]::new);
        expectedResult2= Stream.concat(Arrays.stream(arr), Arrays.stream(arr2)).sorted().toArray(Integer[]::new);
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

    void compareResult(DoubleLinkedListNode root, Integer[] result) {
        DoubleLinkedListNode head = root;
        for (int j : result) {
            assertEquals(j, head.val);
            head = head.next;
        }
        assertNull(head);
    }
}