package chapter4.exercise13;

import java.util.Arrays;

public class Exercise13 {
    public static int getMaxPresence(int[] in, int[] out) {
        Arrays.sort(in);
        Arrays.sort(out);

        int i = 0;
        int j = 0;

        int count = 0;
        int max = Integer.MIN_VALUE;

        while (i < in.length && j < out.length) {
            if (in[i] < out[j]) {
                count++;
                if (count > max)
                    max = count;
                i++;
            } else {
                count--;
                j++;
            }
        }

        return max;
    }
}
