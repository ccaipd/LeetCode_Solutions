package Randomized;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

class RandomPickwithBlacklist {
    // https://leetcode.com/problems/random-pick-with-blacklist/discuss/432609/Java-HashMap-solution-with-explanation
    /** Idea is to shift the whitelisted number up and
     take the random index from 0 to whitelisted.length

     For e.g. N = 6
     blacklist = {2, 3, 4}

     1, 2, 3, 4, 5, 6
     w  b  b  b  w  w

     Only 3 whitelisted,
     so swap 2 with 5 & swap 3 with 6

     which make the arr
     1, 5, 6, 4, 2, 3
     w  w  w  b  b  b

     And then take random number from 0 - whitelisted.lenth
     */
    Random rand = new Random();
    Map<Integer, Integer> hm = new HashMap<>();
    int blen;
    int wlen;
    // fair solution but TLE!
    public RandomPickwithBlacklist(int n, int[] blacklist) {
        blen = blacklist.length;
        wlen = n - blen;
        // bl: [2, 3, 4]
        Set<Integer> bl = new HashSet<>();
        for(int i: blacklist)
            bl.add(i);
        // wl: [1, 5, 6]
        List<Integer> wl = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(!bl.contains(i))
                wl.add(i);
        }
        int j = wl.size();
        for(int i = 0; i < wlen; i++) {
            if(bl.isEmpty())
                break;
            // map curr element(that exists in bl) with wl element(from its tail)
            if(bl.contains(i)) {
                hm.put(i, wl.get(j - 1));
                j--;
                bl.remove(i); // remove element from bl, so we might end the loop earilier
            }
        }
        // System.out.println(bl);
        // System.out.println(wl);
        // System.out.println(hm);
    }

    public int pick() {
        int k = rand.nextInt(wlen);
        return hm.getOrDefault(k, k);
    }

    /* Acceptable Solution(same idea)
    Random rand = new Random();
    Map<Integer, Integer> hm = new HashMap<>();
    int blen;
    int wlen;

    public Solution(int n, int[] blacklist) {
        blen = blacklist.length;
        wlen = n - blen;

        Set<Integer> wl = new HashSet<>();
        // [4, 5, 6]
        for(int i = wlen; i < n; i++)
            wl.add(i);
        // [5, 6]
        for(int i = 0; i < blacklist.length; i++)
            wl.remove(blacklist[i]);

        Iterator<Integer> itr = wl.iterator();
        for(int i = 0; i < blen; i++) {
            if(blacklist[i] < wlen) {
                int val = itr.next();
                hm.put(blacklist[i], val);
            }
        }
    }

    public int pick() {
        int k = rand.nextInt(wlen);
        return hm.getOrDefault(k, k);
    }
    */
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */
