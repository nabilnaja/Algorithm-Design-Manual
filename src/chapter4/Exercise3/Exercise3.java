package chapter4.Exercise3;

import java.util.Arrays;

public class Exercise3 {

    static public int[][] minimzePair(int[] array) {
        assert array.length > 1;
        assert (array.length & 1) == 0;
        Arrays.sort(array);
        int[][] result = new int[array.length / 2][2];
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            result[start] = new int[]{array[start], array[end]};
            start ++;
            end --;
        }
        return result;
    }


}
