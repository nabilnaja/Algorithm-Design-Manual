package chapter3.exercise1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class exercise1Test {
    public static List<String> correct;
    public static List<String> incorrect;

    @BeforeAll
    public void BeforeAll(){
        correct = Arrays.asList(null, "", "(())", "(()()())()", "()(()(())())", "()(())(())()");
        incorrect = Arrays.asList("(()()", ")()()",  "(()((()())()", "()(()))(())()");
    }
    @Test
    void isBalancedStack() {
        assertTrue(correct.stream().allMatch(Exercise1::isBalancedStack));
        assertTrue(incorrect.stream().noneMatch(Exercise1::isBalancedStack));
    }
    @Test
    void isBalanced() {
        assertTrue(correct.stream().allMatch(Exercise1::isBalanced));
        assertTrue(incorrect.stream().noneMatch(Exercise1::isBalanced));
    }
}