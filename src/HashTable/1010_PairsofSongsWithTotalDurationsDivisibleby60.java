package HashTable;

class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        // optimized solution
        // O(N)
        int[] counter = new int[60];
        int count = 0;
        for(int t: time) {
            int index = t % 60;
            if(index == 0)
                count += counter[index];
            else
                count += counter[60 - index];

            counter[index]++;
        }
        return count;

        /*
        // O(N * 60)
        int[] counter = new int[60];
        int count = 0;
        for(int t: time) {
            for(int i = 0; i < 60; i++) {
                if(counter[i] != 0 && (i + t) % 60 == 0)
                    count += counter[i];
            }
            counter[t % 60]++;
        }
        return count;
        */
    }
}