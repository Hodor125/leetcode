package String.Leetcode32;


import java.util.Deque;
import java.util.LinkedList;

/**
 * 字符串索引和数组一样
 * 什么神仙算法，想不到
 */
public class Solution {
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new LinkedList<>();

        int max = 0;
        int len = s.length();
        stack.push(-1);
        for (int i = 0; i < len; i++) {
            if(s.charAt(i) == '('){
                stack.push(i);
            }
            if(s.charAt(i) == ')'){
                stack.pop();
                if(stack.size() == 0){
                    //放入最后一个没有匹配的右括号的下标
                    stack.push(i);
                } else {
                    max = Math.max(i - stack.peek(),max);
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {


        String str = "(()()))()()(";
        Solution solution = new Solution();
        int ans = solution.longestValidParentheses(str);
        System.out.println(ans);
    }
}