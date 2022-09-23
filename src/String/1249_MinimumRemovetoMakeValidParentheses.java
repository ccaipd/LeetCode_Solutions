package String;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

class Solution {
    public String minRemoveToMakeValid(String s) {
        // O(N) two passes
        Queue<Integer> index = new PriorityQueue<>(); // using Set will be faster
        Stack<Integer> stack = new Stack<>();
        // store indice of invalid parentheses
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            } else if(s.charAt(i) == ')') {
                if(!stack.isEmpty())
                    stack.pop();
                else
                    index.add(i);
            }
        }
        while(!stack.isEmpty())
            index.add(stack.pop());

        StringBuilder res = new StringBuilder();
        int i = 0;
        while(i < s.length() && !index.isEmpty()) {
            if(i != index.peek())  // if(!Set.contains(i))
                res.append(s.charAt(i));
            else
                index.poll();
            i++;
        }
        // attach remaining letters if index queue went empty
        while(i < s.length())
            res.append(s.charAt(i++));

        return res.toString();
    }
}