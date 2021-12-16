package chapter3.exercise26;

import dt.SegmentTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Exercise26bTest {


    @Test
    void findWordByPrefix_1() {
        final int[] values = {4, 3, 7, 1, 20};
        int n = values.length;
        SegmentTree segmentTree = new SegmentTree();
        segmentTree.constructST(values, n);

        Assertions.assertEquals(3,segmentTree.RMQ(n, 0, 1));
        Assertions.assertEquals(4,segmentTree.RMQ(n, 0, 0));
        Assertions.assertEquals(1,segmentTree.RMQ(n, 1, 3));
        Assertions.assertEquals(1,segmentTree.RMQ(n, 0, 4));
        Assertions.assertEquals(1,segmentTree.RMQ(n, 3, 4));
        Assertions.assertEquals(3,segmentTree.RMQ(n, 0, 2));
        Assertions.assertEquals(20,segmentTree.RMQ(n, 4, 4));
    }

}