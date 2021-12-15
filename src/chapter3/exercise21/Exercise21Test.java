package chapter3.exercise21;

import dt.TreeNode;
import dt.TreeNodeHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Exercise21Test {

    TreeNode<Integer> firstTree;
    TreeNode<Integer> secondTree;
    TreeNodeHelper<Integer> treeNodeHelper = new TreeNodeHelper<>();
    Integer[] expectedResult;
    int size1 = 10;

    @BeforeAll
    void setUp() {
        final Integer[] arr = IntStream.range(0, size1).boxed().limit(size1).toArray(Integer[]::new);
        firstTree = treeNodeHelper.sortedArrayToBST(arr, 0, size1 - 1);
        final Integer[] arr1 = IntStream.range(size1, size1 * 2).boxed().toArray(Integer[]::new);
        secondTree = treeNodeHelper.sortedArrayToBST(arr1, 0, size1 - 1);
        expectedResult = Stream.concat(Arrays.stream(arr), Arrays.stream(arr1)).toArray(Integer[]::new);

    }

    @Test
    void concat() {
        final TreeNode<Integer> result = Exercise21.concat(firstTree, secondTree);
        List<Integer> arrayResult = treeNodeHelper.bstToArray(result);
        IntStream.range(0, arrayResult.size()).forEach(i -> assertEquals(expectedResult[i], arrayResult.get(i)));
    }
}