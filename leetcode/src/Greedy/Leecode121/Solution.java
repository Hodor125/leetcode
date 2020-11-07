package Greedy.Leecode121;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        Solution s = new Solution();
        System.out.println(s.maxProfit(arr));
    }
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max_profit = 0;

        for (int i = 0; i < prices.length; i++) {
            if(prices[i] < min)
                min = prices[i];
            else if(prices[i] - min >= max_profit)
                max_profit = prices[i] - min;
        }
        return max_profit;
    }
}
