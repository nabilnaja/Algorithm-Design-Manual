package chapter3.exercise27;

public class Exercise27 {

    public static int[] findSumSubset(int[] set, int sum) {
        if (!blackBox(set, set.length, sum))
            return new int[]{};
        int temp;
        for (int i = 1; i <= set.length; i++) {
            temp = set[i - 1];
            set[i - 1] = 0;
            if (blackBox(set, set.length, sum))
                return removeFromSet(set);
            set[i - 1] = temp;
        }
        return set;
    }

    private static int[] removeFromSet(int[] set) {
        int[] subset = new int[set.length - 1];
        for (int i = 0, k = 0; i < set.length; i++) {
            if (set[i] == 0) {
                continue;
            }
            subset[k++] = set[i];
        }

        // return the resultant array
        return subset;
    }


    // https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
    private static boolean blackBox(int[] set, int n, int sum) {
        boolean[][] subset = new boolean[sum + 1][n + 1];

        for (int i = 0; i <= n; i++)
            subset[0][i] = true;

        for (int i = 1; i <= sum; i++)
            subset[i][0] = false;

        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                subset[i][j] = subset[i][j - 1];
                if (i >= set[j - 1])
                    subset[i][j] = subset[i][j]
                            || subset[i - set[j - 1]][j - 1];
            }
        }
        return subset[sum][n];
    }
}
