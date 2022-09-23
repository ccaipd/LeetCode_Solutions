package String;

class Solution {
    public void reverseWords(char[] s) {
        // O(N + N) 2 passes
        // the idea is to reverse the whole string and then reverse each word
        reverse(s, 0, s.length - 1);

        int start = 0, end = 0;
        while(end < s.length) {
            if(s[end] == ' ') {
                reverse(s, start, end - 1);
                start = end + 1;
            }
            end++;
        }

        reverse(s, start, end - 1); // reverse last word or whole word if no space in separate
    }

    public void reverse(char[] s, int i, int j) {
        while(i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}