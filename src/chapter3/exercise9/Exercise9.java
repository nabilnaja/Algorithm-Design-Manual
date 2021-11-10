package chapter3.exercise9;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class Exercise9 {

    Map<Integer, String> phoneKey;

    public Exercise9() {
        phoneKey = Map.ofEntries(
                new AbstractMap.SimpleEntry<>(2, "abc"),
                new AbstractMap.SimpleEntry<>(3, "def"),
                new AbstractMap.SimpleEntry<>(4, "ghi"),
                new AbstractMap.SimpleEntry<>(5, "jkl"),
                new AbstractMap.SimpleEntry<>(6, "mno"),
                new AbstractMap.SimpleEntry<>(7, "pqrs"),
                new AbstractMap.SimpleEntry<>(8, "tuv"),
                new AbstractMap.SimpleEntry<>(9, "wxyz")
        );
    }

}
