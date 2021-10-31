package chapter3;

import org.junit.platform.commons.util.StringUtils;

import java.util.*;

public class Exercise1 {
    public List<String> correct;
    public List<String> incorrect;
    private static final char closing = ')';
    private static final char opening = '(';

    public Exercise1(){
        correct = Arrays.asList(null, "", "(())", "(()()())()", "()(()(())())", "()(())(())()");
        incorrect = Arrays.asList("(()()", ")()()",  "(()((()())()", "()(()))(())()");
    }


    public static boolean isBalancedStack(String s){
        if (StringUtils.isBlank(s))
            return true;

        Stack<Character> queue = new Stack<>();
        for (int i = 0, n = s.length(); i < n; i++) {
            if (s.charAt(i) != opening && s.charAt(i) != closing){
                throw new IllegalArgumentException();
            }
            if (s.charAt(i) == opening)
                queue.add(s.charAt(i));
            else if (s.charAt(i) == closing && queue.size() != 0 && queue.peek() == opening){
                queue.pop();
            }
            else{
                return false;
            }
        }
        return queue.size() == 0;
    }

    public static boolean isBalanced(String s) {
        if (StringUtils.isBlank(s))
            return true;
        int count = 0;
        for (int i = 0, n = s.length(); i < n; i++) {
            switch (s.charAt(i)) {
                case '(' -> count++;
                case ')' -> count--;
                default -> throw new IllegalArgumentException();
            }

            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }
}
