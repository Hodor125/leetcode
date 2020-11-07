package Stack.Leetcode20;

import java.util.LinkedList;
import java.util.Stack;

public class Solution {
        public boolean isValid(String s) {
            if(s == null || s.length() == 0)
                return true;

            Stack<Character> stack = new Stack<>();
            int len = s.length();
            for (int i = 0; i < len; i++) {
                if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                    stack.push(s.charAt(i));
                else if(s.charAt(i) == ')'){
                    if(stack.size() == 0)
                        return false;
                    char t = stack.pop();
                    if(t != '(')
                        return false;
                } else if(s.charAt(i) == ']'){
                    if(stack.size() == 0)
                        return false;
                    char t = stack.pop();
                    if(t != '[')
                        return false;
                } else if (s.charAt(i) == '}'){
                    if(stack.size() == 0)
                        return false;
                    char t = stack.pop();
                    if(t != '{')
                        return false;
                }
            }

            if(stack.size() == 0)
                return true;
            return false;
        }

    public static void main(String[] args) {
        String brackets = "()";
        Solution solution = new Solution();
        boolean ans = solution.isValid(brackets);
        System.out.println(ans);
    }
}
