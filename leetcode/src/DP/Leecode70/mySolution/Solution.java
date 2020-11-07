package DP.Leecode70.mySolution;

import sun.swing.MenuItemLayoutHelper;

//二刷
public class Solution {
    public int climbStairs(int n) {
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;

        int[][] count = new int[n + 1][2];

        count[1][1] = 1;
        count[2][1] = 2;
        for (int i = 3; i < n + 1; i++) {
            count[i][1] = count[i - 1][1] + count[i - 2][1];
        }
        return count[n][1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int ans = solution.climbStairs(1);
        System.out.println(ans);
    }
}
