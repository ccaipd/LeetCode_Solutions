package String;

import java.util.Stack;

class Solution {
    public String removeDuplicates(String s, int k) {
        // O(N)
        Stack<Character> stack = new Stack<>();
        Stack<Integer> counter = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!stack.isEmpty() && c == stack.peek())
                counter.push(counter.peek() + 1);
            else
                counter.push(1);

            stack.push(c);

            if(counter.peek() == k) {
                int j = 0;
                while(!stack.isEmpty() && j < k) {
                    stack.pop();
                    counter.pop();
                    j++;
                }
            }
            // System.out.println(stack + "\n" + counter);
        }

        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty())
            res.append(stack.pop());

        return res.reverse().toString();
    }

    // workable solution but TLE
//     public String removeDuplicates(String s, int k) {
//         Stack<Character> main = new Stack<>();
//         for(int i = 0; i < s.length(); i++) {
//             char c = s.charAt(i);
//             if(!main.isEmpty()) {
//                 Stack<Character> minor = new Stack<>();
//                 int count = 0;
//                 while(!main.isEmpty() && k > 1 && c == main.peek()) {
//                     minor.push(main.pop());
//                     count++;
//                 }
//                 // System.out.println(main);
//                 if(count < k - 1) {
//                     while(!minor.isEmpty()) {
//                         main.push(minor.pop());
//                     }
//                     main.push(c);
//                 }
//             } else {
//                 main.push(c);
//             }
//         }

//         StringBuilder res = new StringBuilder();
//         while(!main.isEmpty())
//             res.append(main.pop());

//         return res.reverse().toString();
//     }
}