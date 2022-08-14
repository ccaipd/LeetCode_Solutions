package Randomized;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class RandomPickIndex {
    Map<Integer, List<Integer>> hm = new HashMap<>();

    public RandomPickIndex(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if(!hm.containsKey(nums[i]))
                hm.put(nums[i], new ArrayList<>());
            hm.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> indice = hm.get(target);
        if(indice.size() > 1) {
            Random rand = new Random();
            int index = rand.nextInt(indice.size());
            return indice.get(index);
        } else
            return indice.get(0);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */