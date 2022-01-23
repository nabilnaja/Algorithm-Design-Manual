package chapter4.exercise4;

import java.util.*;

public class Exercise4 {

    public static final String YELLOW = "yellow";
    public static final String BLUE = "blue";
    public static final String RED = "red";

    static public List<Item> sortByColor(List<Item> items) {

        List<Item> result = new ArrayList<>();

        Map<String, List<Item>> buckets = Map.ofEntries(
                new AbstractMap.SimpleEntry<String, List<Item>>(RED, new ArrayList<>()),
                new AbstractMap.SimpleEntry<String, List<Item>>(BLUE, new ArrayList<>()),
                new AbstractMap.SimpleEntry<String, List<Item>>(YELLOW, new ArrayList<>())
        );

        items.forEach(item -> {
            switch (item.color){
                case RED -> buckets.get(RED).add(item);
                case BLUE -> buckets.get(BLUE).add(item);
                case YELLOW -> buckets.get(YELLOW).add(item);
                default -> System.out.println("Wrong color");
            }
        });

        result.addAll(buckets.get(RED));
        result.addAll(buckets.get(BLUE));
        result.addAll(buckets.get(YELLOW));

        return result;
    }

}
