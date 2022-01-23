package chapter4.exercise4;

import java.util.Objects;

public class Item {
    int number;
    String color;

    public Item(int number, String color) {
        this.number = number;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return number == item.number && Objects.equals(color, item.color);
    }

}