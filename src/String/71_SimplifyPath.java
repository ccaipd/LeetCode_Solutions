package String;

import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        // O(N + N)
        String[] split = path.split("/");
        // for(String s: split)
        //     System.out.println('"' + s + '"');
        Stack<String> stack = new Stack<>();
        for(String s: split) {
            // System.out.println(stack);
            if(s.equals(".") || s.isEmpty()) {
                continue;
            } else if(s.equals("..")) {
                if(!stack.isEmpty())
                    stack.pop();
            } else
                stack.push(s);
        }

        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()) {
            res.insert(0, "/" + stack.pop());
        }

        return res.length() == 0 ? "/" : res.toString();
    }
}