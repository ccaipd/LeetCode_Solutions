package String;

import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        // TC: O((maxK ^ nestedK) * n)
        // maxK = max value of k, nestedK = count of nested k values, n = max length of encoded string
        // e.g. s = 20[a10[bc]], maxK is 20, nestedK is 2 as there are 2 nested k values (20 and 10). Also, n is 2 as there are 2 encoded strings a and bc with maximum length of encoded string of 2
        // SC: O((sum(maxK ^ nestedK) * n))
        Stack<String> stack = new Stack<>();
        int i = 0;
        while(i < s.length()) {
            // form number k
            if(Character.isDigit(s.charAt(i))) {
                int num = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i))) {
                    int val = Character.getNumericValue(s.charAt(i));
                    num = 10 * (int)num + val;
                    i++;
                }
                // System.out.println(num);
                stack.push(String.valueOf(num));
                continue;
            }
            else if(s.charAt(i) == ']') {
                StringBuilder sb = new StringBuilder();
                while(!stack.isEmpty() && !stack.peek().equals("[")) {
                    sb.insert(0, stack.pop());
                }
                stack.pop(); // pop out '['

                int k = Integer.parseInt(stack.pop());
                String str = formNestedString(k, sb.toString());
                stack.push(str);
            }
            else {
                stack.push(String.valueOf(s.charAt(i)));
            }
            // System.out.println(stack);
            i++;
        }
        // stack now contains all encoded string, pop them out and append them backwards
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }

        return res.toString();
    }

    public String formNestedString(int k, String s) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < k; i++)
            res.append(s);
        return res.toString();
    }
}