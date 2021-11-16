package chapter3.exercise10;

public class Exercise10 {

    public static boolean areAnagrams(String w1, String w2) {
        if (w1.length() != w2.length()) {
            return false;
        }
        int[] letterCount = new int[26];

        for (int i = 0; i < w1.length(); i++) {
            letterCount[w1.charAt(i) - 97]++;
            letterCount[w2.charAt(i) - 97]--;
        }
        for (int i : letterCount) {
            if (i != 0)
                return false;
        }
        return true;
    }

}
