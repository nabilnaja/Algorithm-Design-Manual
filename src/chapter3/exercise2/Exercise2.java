package chapter3.exercise2;

import org.junit.platform.commons.util.StringUtils;

import java.util.concurrent.atomic.AtomicInteger;

public class Exercise2 {

    private static final char closing = ')';
    private static final char opening = '(';

    public static int longestBalancedParentheses(String s) {
        AtomicInteger longest = new AtomicInteger(0);
        AtomicInteger current = new AtomicInteger(0);
        AtomicInteger count = new AtomicInteger(0);
        if (StringUtils.isBlank(s))
            return 0;

        s.chars().forEach(currentChar -> checkLongestBalanced(longest, current, count, currentChar));

        return Math.max(current.get() - count.get(), longest.get());
    }

    private static void checkLongestBalanced(AtomicInteger longest, AtomicInteger current, AtomicInteger count, int currentChar) {
        if (currentChar != opening && currentChar != closing) {
            throw new IllegalArgumentException();
        }

        switch (currentChar) {
            case '(' -> count.getAndIncrement();
            case ')' -> count.getAndDecrement();
            default -> throw new IllegalArgumentException();
        }

        current.getAndIncrement();
        if (count.get() < 0){
            longest.set(Math.max(current.decrementAndGet(), longest.get()));
            current.set(0);
            count.set(0);
        }
    }
}
