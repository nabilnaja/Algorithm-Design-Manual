package chapter3.exercise12;

import dt.TreeNode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Exercise12Test {

    public static int[] tree1;
    public static int[] tree2;
    public static int[] tree3;
    public static int[] tree4;
    public static TreeNode root1;
    public static TreeNode root2;
    public static TreeNode root3;
    public static TreeNode root4;

    @BeforeAll
    void setUp() {
        tree1 = IntStream.range(0,4).toArray();
        tree2 = IntStream.range(0,8).toArray();
        tree3 = IntStream.range(0,16).toArray();
        tree4 = IntStream.range(0,32).toArray();

        root1 = TreeNode.arrayToTree(tree1);
        root2 = TreeNode.arrayToTree(tree2);
        root3 = TreeNode.arrayToTree(tree3);
        root4 = TreeNode.arrayToTree(tree4);
    }

    @Test
    void isBalancedStack() {
        assertEquals(3, Exercise12.maxDepth(root1));
        assertEquals(4, Exercise12.maxDepth(root2));
        assertEquals(5, Exercise12.maxDepth(root3));
        assertEquals(6, Exercise12.maxDepth(root4));
        assertEquals(1, Exercise12.maxDepth(new TreeNode(1)));
        assertEquals(0, Exercise12.maxDepth(null));
    }
}