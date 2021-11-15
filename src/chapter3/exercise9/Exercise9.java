package chapter3.exercise9;


import java.util.*;

public class Exercise9 {

    private static Map<Character, Integer> letterToPhoneKey;

    static {
        letterToPhoneKey = generateLetterPhoneKeyMapping();
    }

    public Exercise9() {

    }

    public static List<String> phoneKeyToWord(String phoneKey, List<String> words) {
        final Map<String, List<String>> hashedWords = hashWords(words);
        if (hashedWords.containsKey(phoneKey)) {
            return hashedWords.get(phoneKey);
        }
        return new ArrayList<>();
    }

    private static Map<Character, Integer> generateLetterPhoneKeyMapping() {
        return Map.ofEntries(
                new AbstractMap.SimpleEntry<>('a', 2),
                new AbstractMap.SimpleEntry<>('b', 2),
                new AbstractMap.SimpleEntry<>('c', 2),
                new AbstractMap.SimpleEntry<>('d', 3),
                new AbstractMap.SimpleEntry<>('e', 3),
                new AbstractMap.SimpleEntry<>('f', 3),
                new AbstractMap.SimpleEntry<>('g', 4),
                new AbstractMap.SimpleEntry<>('h', 4),
                new AbstractMap.SimpleEntry<>('i', 4),
                new AbstractMap.SimpleEntry<>('j', 5),
                new AbstractMap.SimpleEntry<>('k', 5),
                new AbstractMap.SimpleEntry<>('l', 5),
                new AbstractMap.SimpleEntry<>('m', 6),
                new AbstractMap.SimpleEntry<>('n', 6),
                new AbstractMap.SimpleEntry<>('o', 6),
                new AbstractMap.SimpleEntry<>('p', 7),
                new AbstractMap.SimpleEntry<>('q', 7),
                new AbstractMap.SimpleEntry<>('r', 7),
                new AbstractMap.SimpleEntry<>('s', 7),
                new AbstractMap.SimpleEntry<>('t', 8),
                new AbstractMap.SimpleEntry<>('u', 8),
                new AbstractMap.SimpleEntry<>('v', 8),
                new AbstractMap.SimpleEntry<>('w', 9),
                new AbstractMap.SimpleEntry<>('x', 9),
                new AbstractMap.SimpleEntry<>('y', 9),
                new AbstractMap.SimpleEntry<>('z', 9)
        );
    }


    private static Map<String, List<String>> hashWords(List<String> words) {
        Map<String, List<String>> hashedWords = new HashMap<>();
        words.forEach(s -> {
            final String hash = hashWord(s, letterToPhoneKey);
            hashedWords.computeIfAbsent(hash, k -> new ArrayList<>()).add(s);
        });
        return hashedWords;
    }

    private static String hashWord(String word, Map<Character, Integer> letterToPhoneKey) {
        StringBuilder sb = new StringBuilder();
        // the map should contain the character. we may add few test to check if the letter exist or if the word contains special char
        word.chars().forEach(ch -> sb.append(letterToPhoneKey.get((char) ch)));
        return sb.toString();
    }

}
