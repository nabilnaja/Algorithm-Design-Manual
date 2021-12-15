package chapter3.exercise12;

import dt.TreeNode;
import dt.TreeNodeHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Exercise12Test {

    TreeNodeHelper<Integer> treeNodeHelper = new TreeNodeHelper<>();

    public static Integer[] tree1;
    public static Integer[] tree2;
    public static Integer[] tree3;
    public static Integer[] tree4;
    public static TreeNode<Integer> root1;
    public static TreeNode<Integer> root2;
    public static TreeNode<Integer> root3;
    public static TreeNode<Integer> root4;

    @BeforeAll
    void setUp() {
        tree1 = IntStream.range(0,4).boxed().toArray(Integer[]::new);
        tree2 = IntStream.range(0,8).boxed().toArray(Integer[]::new);
        tree3 = IntStream.range(0,16).boxed().toArray(Integer[]::new);
        tree4 = IntStream.range(0,32).boxed().toArray(Integer[]::new);

        root1 = treeNodeHelper.arrayToTree(tree1);
        root2 = treeNodeHelper.arrayToTree(tree2);
        root3 = treeNodeHelper.arrayToTree(tree3);
        root4 = treeNodeHelper.arrayToTree(tree4);
    }

    @Test
    void isBalancedStack() {
        assertEquals(3, Exercise12.maxDepth(root1));
        assertEquals(4, Exercise12.maxDepth(root2));
        assertEquals(5, Exercise12.maxDepth(root3));
        assertEquals(6, Exercise12.maxDepth(root4));
        assertEquals(1, Exercise12.maxDepth(new TreeNode<>(1)));
        assertEquals(0, Exercise12.maxDepth(null));
    }
}