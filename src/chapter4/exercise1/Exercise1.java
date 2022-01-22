package chapter4.exercise1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise1 {

    public List<Player> mergeSort(List<Integer> ratings) {
        final List<Player> players = ratings.stream().map(Player::new).collect(Collectors.toList());
        divide(players, 0, players.size() - 1);
        return players;
    }

    private void divide(List<Player> players, int startIndex, int endIndex) {
        if (startIndex < endIndex && (endIndex - startIndex) >= 1) {
            int mid = (endIndex + startIndex) / 2;
            divide(players, startIndex, mid);
            divide(players, mid + 1, endIndex);

            merge(players, startIndex, mid, endIndex);
        }
    }

    private void merge(List<Player> players, int startIndex, int midIndex, int endIndex) {
        ArrayList<Player> mergedList = new ArrayList<>();

        int leftIndex = startIndex;
        int rightIndex = midIndex + 1;

        while (leftIndex <= midIndex && rightIndex <= endIndex) {
            if (players.get(leftIndex).rating <= players.get(rightIndex).rating) {
                mergedList.add(players.get(leftIndex));
                leftIndex++;
            } else {
                mergedList.add(players.get(rightIndex));
                rightIndex++;
            }
        }

        //Either of below while loop will execute
        while (leftIndex <= midIndex) {
            mergedList.add(players.get(leftIndex));
            leftIndex++;
        }

        while (rightIndex <= endIndex) {
            mergedList.add(players.get(rightIndex));
            rightIndex++;
        }

        int i = 0;
        int j = startIndex;
        //Setting sorted array to original one
        while (i < mergedList.size()) {
            players.set(j, mergedList.get(i++));
            j++;
        }
    }

    public static class Player {
        int rating;

        public Player(int rating) {
            this.rating = rating;
        }
    }

}
