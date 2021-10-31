package chapter3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class exercise1Test {
    Exercise1 exercise1;

    @BeforeAll
    public void BeforeAll(){
        exercise1 = new Exercise1();
    }
    @Test
    void isBalancedStack() {
        assertTrue(exercise1.correct.stream().allMatch(Exercise1::isBalancedStack));
        assertTrue(exercise1.incorrect.stream().noneMatch(Exercise1::isBalancedStack));
    }
    @Test
    void isBalanced() {
        assertTrue(exercise1.correct.stream().allMatch(Exercise1::isBalanced));
        assertTrue(exercise1.incorrect.stream().noneMatch(Exercise1::isBalanced));
    }
}