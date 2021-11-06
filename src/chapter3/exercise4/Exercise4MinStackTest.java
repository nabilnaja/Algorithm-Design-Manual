package chapter3.exercise4;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Exercise4MinStackTest {

    Exercise4MinStack stack;

    @BeforeAll
    public void BeforeAll() {
        stack = new Exercise4MinStack();
    }

    @Test
    public void minStack() {
        pushAndAssert(20, 20);
        pushAndAssert(15, 15);
        popAndAssert(20, 20);
        pushAndAssert(18, 18);
        pushAndAssert(25, 18);
        pushAndAssert(53, 18);
        pushAndAssert(32, 18);
        pushAndAssert(7, 7);
        popAndAssert(32, 18);
        pushAndAssert(1, 1);
        pushAndAssert(5, 1);
        pushAndAssert(-1, -1);
    }

    private void pushAndAssert(int pushedItem, int min) {
        stack.push(pushedItem);
        checkMinPeek(pushedItem, min);
    }

    private void popAndAssert(int peak, int min) {
        int item = stack.pop();
        checkMinPeek(peak, min);
    }

    private void checkMinPeek(int peak, int min) {
        assertEquals(min, stack.getMin());
        assertEquals(peak, stack.peek());
    }
}