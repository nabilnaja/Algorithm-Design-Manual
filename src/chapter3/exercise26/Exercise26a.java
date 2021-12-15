package chapter3.exercise26;

public class Exercise26a {

    int[][] cache;
    int size;

    public Exercise26a(int[] values) {
        cache = new int[values.length][values.length];
        size = values.length;
        buildAnswers(values);
    }

    private void buildAnswers(int[] values) {
        for (int i = 0; i < values.length; i++) {
            for (int j = i; j < values.length; j++) {
                cache[i][j] = findMin(values, i, j);
            }
        }
    }

    private int findMin(int[] values, int start, int end) {
        int min = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            if (values[i] < min) {
                min = values[i];
            }
        }
        return min;
    }

    public int getMinRange(int min, int max) {
        if (min >= size || max >= size)
            return Integer.MAX_VALUE;
        return cache[min][max];
    }

}