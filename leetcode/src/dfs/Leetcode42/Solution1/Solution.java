package dfs.Leetcode42.Solution1;

/**
 * 暴力遍历
 * @author ：hodor007
 * @date ：Created in 2020/10/28
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public int trap(int[] height) {
        //排除特殊情况
        int ans = 0;
        int len = height.length;
        for (int i = 1; i < len - 1; i++) {
            int maxL = 0,maxR = 0;
            for (int j = i; j >= 0 ; j--) {
                maxL = Math.max(maxL,height[j]);
            }
            for (int j = i; j < len; j++) {
                maxR = Math.max(maxR,height[j]);
            }
            ans += Math.min(maxL,maxR) - height[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        Solution solution = new Solution();
        int ans = solution.trap(arr);
        System.out.println(ans);
    }
}
