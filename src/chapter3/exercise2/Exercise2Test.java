package chapter3.exercise2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.AbstractMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Exercise2Test {
    Map<String, Integer> testCase;

    @BeforeAll
    public void BeforeAll() {
        testCase = Map.ofEntries(
                new AbstractMap.SimpleEntry<>("", 0),
                new AbstractMap.SimpleEntry<>("((()", 2),
                new AbstractMap.SimpleEntry<>(")()())", 4),
                new AbstractMap.SimpleEntry<>(")()()()))))", 6),
                new AbstractMap.SimpleEntry<>(")()()()((((((", 6),
                new AbstractMap.SimpleEntry<>("()(()))))", 6),
                new AbstractMap.SimpleEntry<>(")()(())()()))())))(", 10),
                new AbstractMap.SimpleEntry<>("()()())()()", 6),
                new AbstractMap.SimpleEntry<>(")(())((()()))", 12),
                new AbstractMap.SimpleEntry<>("(((((((())))))))()", 18),
                new AbstractMap.SimpleEntry<>("(())))()()()))((((())))))", 10)
        );
    }
    @Test
    public void longestBalancedParentheses(){
        testCase.forEach((s, expectedLength) -> assertEquals(expectedLength, Exercise2.longestBalancedParentheses(s)));
    }
}