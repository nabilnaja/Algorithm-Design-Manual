package chapter3.exercise26;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Exercise26aTest {


    @Test
    void findWordByPrefix_1() {
        final int[] values = {4, 3, 7, 1, 20};
        Exercise26a exercise26a = new Exercise26a(values);
        Assertions.assertEquals(3, exercise26a.getMinRange(0, 1));
        Assertions.assertEquals(4, exercise26a.getMinRange(0, 0));
        Assertions.assertEquals(1, exercise26a.getMinRange(1, 3));
        Assertions.assertEquals(1, exercise26a.getMinRange(0, 4));
        Assertions.assertEquals(1, exercise26a.getMinRange(3, 4));
        Assertions.assertEquals(3, exercise26a.getMinRange(0, 2));
        Assertions.assertEquals(20, exercise26a.getMinRange(4, 4));

    }

}