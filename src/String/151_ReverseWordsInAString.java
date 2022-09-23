package String;

class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] split = s.split("\\s+");
        StringBuilder res = new StringBuilder();
        for(int i = split.length - 1; i >= 0; i--) {
            if(i == 0)
                res.append(split[i]);
            else
                res.append(split[i] + " ");
        }
        return res.toString();
    }
}