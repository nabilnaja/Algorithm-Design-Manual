package chapter3.exercise24;

import java.util.HashMap;
import java.util.Map;

public class Exercise24 {

    public Exercise24(){
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k) {
        Map<Integer, Integer> cache = new HashMap<>();
        int i = 0;
        while (i <= k && i < nums.length){
            if (cache.containsKey(nums[i])){
                return true;
            }
            cache.put(nums[i], i);
            i++;
        }

        for (; i < nums.length; i++) {
            cache.remove(nums[i - k - 1]);
            if (cache.containsKey(nums[i])){
                return true;
            }
            cache.put(nums[i], i);
        }
        return false;
    }
}
