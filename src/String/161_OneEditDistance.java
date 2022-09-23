package String;

class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
        if(Math.abs(m - n) > 1)
            return false;
        if(m > n)
            return compare(t, s);
        if(m < n)
            return compare(s, t);
        // if m == n
        int count = 0;
        int i = 0, j = 0;
        while(i < s.length() && j < t.length()) {
            if(s.charAt(i) != t.charAt(j))
                count++;
            i++;
            j++;

            if(count > 1)
                return false;
        }

        if(count == 0 || count > 1)
            return false;
        return true;
    }

    public boolean compare(String s, String t) {
        int count = 0;
        int i = 0, j = 0;
        while(i < s.length() && j < t.length()) {
            if(s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            }
            else if(s.charAt(i) != t.charAt(j)) {
                count++;
                j++;
            }

            if(count > 1)
                return false;
        }
        if(count > 1)
            return false;
        return true;
    }
}