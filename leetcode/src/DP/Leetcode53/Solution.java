package DP.Leetcode53;

/**
 * 定义状态很重要，好像字符串数组挺多dp问题都喜欢从末尾开始
 * @author ：hodor007
 * @date ：Created in 2020/10/30
 * @description ：
 * @version: 1.0
 */
public class Solution {
        public int maxSubArray(int[] nums) {
            if(nums == null)
                return 0;
            if(nums.length == 1)
                return nums[0];

            int pre = nums[0];  //以前一个节点结尾的最长子串的和
            int maxi = 0; //以nums[i]结尾的和最大的子串
            int max = nums[0]; //最长子串的和
            for (int i = 1; i < nums.length; i++) {
                maxi = Math.max(nums[i],nums[i] + pre);
                pre = maxi;
                max = Math.max(max,maxi);
            }
            return max;
        }

    public static void main(String[] args) {
        int[] arr = {-2,-1};
        Solution solution = new Solution();
        int ans = solution.maxSubArray(arr);
        System.out.println(ans);
    }
}
