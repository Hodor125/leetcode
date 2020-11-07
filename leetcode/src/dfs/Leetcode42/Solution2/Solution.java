package dfs.Leetcode42.Solution2;

/**
 * 所谓的动态规划
 * @author ：hodor007
 * @date ：Created in 2020/10/28
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public int trap(int[] height) {
        if (height == null)
            return 0;

        int len = height.length;
        int[] maxL = new int[len];
        int[] maxR = new int[len];

        int temp = height[0];
        for (int i = 0; i < len; i++) {
            if(height[i] > temp)
                temp = height[i];
            maxL[i] = temp;
        }

        temp = height[len - 1];
        for (int i = len - 1; i >= 0; i--) {
            if(height[i] > temp)
                temp = height[i];
            maxR[i] = temp;
        }

        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans += Math.min(maxL[i],maxR[i]) - height[i];
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
