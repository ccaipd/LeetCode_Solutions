package Backtracking;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> perm = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        // Time: O(N * N!)
        // Space: O(N!)
        backtrack(0, nums, new ArrayList<>());
        return perm;
    }

    public void backtrack(int start, int[] nums, List<Integer> curr) {
        if(nums.length == curr.size()) {
            perm.add(new ArrayList<Integer>(curr));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(curr.contains(nums[i]))
                continue;

            curr.add(nums[i]);
            backtrack(i + 1, nums, curr);
            curr.remove(curr.size() - 1);
        }
    }

}