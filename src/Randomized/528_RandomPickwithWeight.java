package Randomized;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class RandomPickwithWeight {
    // the linear search can be optimized by binary search, as the prefix sum array is sorted in ascending order
    int totalWeight = 0;
    List<Integer> indice = new ArrayList<>();
    int[] prefixSum;

    public RandomPickwithWeight(int[] w) {
        prefixSum = new int[w.length];
        for(int i = 0; i < w.length; i++) {
            totalWeight += w[i];
            prefixSum[i] = totalWeight;
            indice.add(i);
        }
    }

    public int pickIndex() {
        Random rand = new Random();
        int n = rand.nextInt(totalWeight);
        int i = 0;
        for(; i < prefixSum.length; i++) {
            if(n < prefixSum[i])
                return indice.get(i);
        }
        return indice.get(indice.size() - 1);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */