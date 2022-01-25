package chapter4.exercise7;

import java.util.Arrays;

public class Exercise7 {

    public static int hIndex(int[] citations) {
        int hIndex = 0;
        int citationsSize = citations.length - 1;
        Arrays.sort(citations);
        while (hIndex < citations.length && citations[citationsSize - hIndex] > hIndex) {
            hIndex++;
        }
        return hIndex;
    }

}
