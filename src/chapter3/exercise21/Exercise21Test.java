package chapter3.exercise21;

import dt.TreeNode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Exercise21Test {

    TreeNode firstTree;
    TreeNode secondTree;
    int[] expectedResult;
    int size1 = 10;

    @BeforeAll
    void setUp() {
        final int[] arr = IntStream.range(0, size1).limit(size1).toArray();
        firstTree = TreeNode.sortedArrayToBST(arr, 0, size1 - 1);
        final int[] arr1 = IntStream.range(size1, size1 * 2).toArray();
        secondTree = TreeNode.sortedArrayToBST(arr1, 0, size1 - 1);
        expectedResult = IntStream.concat(Arrays.stream(arr), Arrays.stream(arr1)).toArray();

    }

    @Test
    void concat() {
        final TreeNode result = Exercise21.concat(firstTree, secondTree);
        Integer[] arrayResult = TreeNode.bstToArray(result).toArray(new Integer[] {});
        IntStream.range(0, arrayResult.length).forEach(i -> assertEquals(expectedResult[i], arrayResult[i]));
    }
}