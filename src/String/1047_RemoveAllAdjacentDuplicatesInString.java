package String;

import java.util.Stack;

class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(!stack.isEmpty() && s.charAt(i) == stack.peek())
                stack.pop();
            else
                stack.push(s.charAt(i));
        }

        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty())
            res.append(stack.pop());

        return res.reverse().toString();
    }
}