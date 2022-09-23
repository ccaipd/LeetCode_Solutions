package TwoPointers;

class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2) return nums.length;

        int count = 1;
        int i = 1, j = 1;
        while(j < nums.length) {
            if(nums[j] == nums[j-1]) // count num freq by j
                count++;
            else
                count = 1;

            if(count <= 2) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }

        return i;
    }
    // similar to 26. Remove Duplicates from Sorted Array
    // https://leetcode.com/problems/remove-duplicates-from-sorted-array/
}