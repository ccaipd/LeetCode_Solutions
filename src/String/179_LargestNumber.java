package String;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String largestNumber(int[] nums) {
        // O(N + NlogN + N)
        String[] sa = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            sa[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(sa, new Comparator<String>(){
            @Override
            public int compare(String a, String b) {
                String s1 = a + b;
                String s2 = b + a;
                return s2.compareTo(s1);
            }
        });

        if(sa[0].equals("0")) // special case if nums contains all 0's
            return "0";

        String res = "";
        for(String s: sa) {
            res += s;
        }

        return res;
    }
}