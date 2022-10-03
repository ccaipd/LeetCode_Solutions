package String;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> commonChars(String[] words) {
        // Time Complexity: O(N * K), N = words.length, K = maximum length of words[i]
        // Space Complexity: O(26 * 2) = O(1)
        int[] counter = new int[26];
        countLetters(words[0], counter); // O(K)

        for(int i = 1; i < words.length; i++) { // O(N)
            int[] freq = new int[26];
            countLetters(words[i], freq); // O(K)

            for(int j = 0; j < freq.length; j++) { // O(26)
                if(freq[j] != 0 && freq[j] <= counter[j])
                    counter[j] = freq[j];
                else if(freq[j] == 0)
                    counter[j] = 0;
            }
        }

        List<String> res = new ArrayList<>();
        for(int i = 0; i < counter.length; i++) { // O(26 * K)
            while(counter[i] > 0) {
                res.add(String.valueOf((char)(i + 'a')));
                counter[i]--;
            }
        }

        return res;
    }

    private void countLetters(String s, int[] counter) {
        for(int i = 0; i < s.length(); i++) { // O(K)
            counter[s.charAt(i) - 'a']++;
        }
    }
}