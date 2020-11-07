package Greedy.Leecode122;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1,7,2,3,6,7,6,7};
        System.out.println(new Solution().maxProfit(arr));
    }

    //贪心算法
    public int maxProfit(int[] prices) {
        int peak = prices[0];
        int valley = prices[0];
        int sum = 0;
        for (int i = 0; i < prices.length; i++) {
            while(i < prices.length - 1 && prices[i + 1] <= prices[i])
                i++;
            valley = prices[i];

            while(i < prices.length -1 && prices[i + 1] >= prices[i])
                i++;
            peak  = prices[i];

            sum += peak - valley;
        }
        return sum;
    }

    public int maxProfit2(int[] prices){
        int len = prices.length;
        int[][]dp = new int[len][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i],dp[i - 1][1]);
        }
        return dp[len - 1][0];
    }
}
