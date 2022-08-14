package HashTable;

import java.util.HashMap;
import java.util.Map;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        int[] res = new int[2];

        for(int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff) && map.get(diff) != i) {
                res[0] = i;
                res[1] = map.get(diff);
                break;
            }
        }

        return res;
    }
}