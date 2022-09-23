package String;

class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        if(word.length() < abbr.length()) return false;
        if(word.length() == 0 || abbr.length() == 0) return true;

        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            if(word.charAt(i) == abbr.charAt(j)) {
                i++;
                j++;
                continue;
            }
            // replacement has leading 0s or replacement is not a number
            if(abbr.charAt(j) == '0' || !Character.isDigit(abbr.charAt(j)))
                return false;

            int count = 0;
            while(j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                count = 10 * count + (int)abbr.charAt(j) - '0';
                j++;
            }

            i += count;
        }

        return i == word.length() && j == abbr.length();
    }
}