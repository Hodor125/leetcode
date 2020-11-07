package dfs.Leetcode42.Solution3;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 思路是计算所有夹在两面墙之间的水
 * @author ：hodor007
 * @date ：Created in 2020/10/28
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int current = 0;
        Deque<Integer> stack = new LinkedList<>();
        while(current < height.length){
            //如果栈为空或者当前的墙的高度小于栈顶的墙的高度则跳过
            while(!stack.isEmpty() && height[current] > height[stack.peekFirst()]){
                //弹出当前的栈顶并保留高度
                int h = height[stack.pollFirst()];
                //如果栈空了，说明没有前面的墙，直接退出循环
                if(stack.isEmpty()){
                    break;
                }
                //计算有多少水
                //先计算长度
                int dist = current - stack.peekFirst() - 1;
                //取较矮的一面墙
                int temp = Math.min(height[current],height[stack.peekFirst()]);
                ans += dist * (temp - h);
            }
            stack.addFirst(current);
            current++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        int ans = solution.trap(arr);
        System.out.println(ans);
    }
}
