package chapter3.exercise11;

import java.util.Arrays;

public class Exercise11 {
    int[] dictionary;

    public Exercise11(int n) {
        dictionary = new int[n];
    }

    public void insert(int data){
        dictionary[data - 1] = data;
    }

    public void delete(int data){
        dictionary[data - 1] = 0;
    }

    public int search(int data){
        return dictionary[data - 1];
    }
}
