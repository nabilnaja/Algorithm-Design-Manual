package chapter3.exercise23;

import dt.TreeNode;
import dt.TreeNodeHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Exercise23Test {
    TreeNodeHelper<String> treeNodeHelper = new TreeNodeHelper<>();

    TreeNode<String> root1;
    TreeNode<String> root2;
    String[] arrayBst1;
    String[] arrayBst2;
    String[] expectedResult1;
    String[] expectedResult2;
    String[] expectedResult5;
    String prefix1;
    String prefix2;
    String prefix5;

    @BeforeAll
    void setUp() {
        root1 = new TreeNode<>();
        prefix1 = "123";
        prefix2 = "aaab";
        prefix5 = "aaabb";
        arrayBst1 = new String[]{"12211", "12212", "12213", "12214", "12215", "12311", "12312", "12313", "12314", "12315", "12316", "12411", "12412", "12413"};
        arrayBst2 = new String[]{"aaaaaa", "aaaaab", "aaaabb", "aaaabc", "aaab", "aaabb", "aaabbc", "aaabel", "aaabpp", "aaacqq", "aaadii", "aaahol", "aaawaa", "aaawbb"};
        root1 = treeNodeHelper.sortedArrayToBST(Stream.of(arrayBst1).sorted().toArray(String[]::new), 0, arrayBst1.length - 1);
        root2 = treeNodeHelper.sortedArrayToBST(Stream.of(arrayBst2).sorted().toArray(String[]::new), 0, arrayBst2.length - 1);
        expectedResult1 = Stream.of(arrayBst1).filter(s -> s.startsWith(prefix1)).sorted().toArray(String[]::new);
        expectedResult2 = Stream.of(arrayBst2).filter(s -> s.startsWith(prefix2)).sorted().toArray(String[]::new);
        expectedResult5 = Stream.of(arrayBst2).filter(s -> s.startsWith(prefix5)).sorted().toArray(String[]::new);
    }

    @Test
    void findWordByPrefix_1() {
        final String[] result1 = Exercise23.wordByPrefix(root1, prefix1).stream().sorted().toArray(String[]::new);
        checkResult(result1, expectedResult1);
    }

    @Test
    void findWordByPrefix_2() {
        final String[] result2 = Exercise23.wordByPrefix(root2, prefix2).stream().sorted().toArray(String[]::new);
        checkResult(result2, expectedResult2);
    }

    @Test
    void findWordByPrefix_3() {
        final String[] result3 = Exercise23.wordByPrefix(root2, "").stream().sorted().toArray(String[]::new);
        checkResult(result3, arrayBst2);
    }

    @Test
    void findWordByPrefix_4() {
        final String[] result4 = Exercise23.wordByPrefix(root2, "xxxxx").stream().sorted().toArray(String[]::new);
        checkResult(result4, new String[0]);
    }

    @Test
    void findWordByPrefix_5() {
        final String[] result5 = Exercise23.wordByPrefix(root2, prefix5).stream().sorted().toArray(String[]::new);
        checkResult(result5, expectedResult5);
    }


    private void checkResult(String[] result, String[] expectedResult) {
        assertEquals(expectedResult.length, result.length);
        IntStream.range(0, result.length).forEach(i -> assertEquals(expectedResult[i], result[i]));
    }


}