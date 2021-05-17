package DP.SO63;

/**
 * 最大股票问题，动态规划，前一天卖出的收益和今天卖出的收益取最大值
 * @author ：hodor007
 * @date ：Created in 2021/3/28
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;
        int len = prices.length;
        //第i天卖出的最大收益
        int[] dp = new int[len + 1];
        dp[0] = 0;
        int cost = prices[0];
        for (int i = 1; i <= len; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i - 1] - cost);
            cost = Math.min(cost, prices[i - 1]);
        }

        int res = 0;
        for (int i = 0; i <= len; i++) {
            res = Math.max(dp[i], res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        Solution solution = new Solution();
        int ans = solution.maxProfit(arr);
        System.out.println(ans);
    }
}
