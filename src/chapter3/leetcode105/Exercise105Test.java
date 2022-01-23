package chapter3.leetcode105;


import dt.AvlTreeSequence;
import dt.AvlTreeSet;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Exercise105Test {


    @BeforeAll
    void setUp() {

    }



    @Test
    void findSumSubsetTest3() {
        chapter3.leetcode105.Solution s = new chapter3.leetcode105.Solution();

        final int[] in = new int[]{1,2,3};
        final int[] pre = new int[]{3,2,1};


        s.buildTree(pre, in);
    }


}