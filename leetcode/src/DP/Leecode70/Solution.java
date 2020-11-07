package DP.Leecode70;

import Array.Leecode509.Solution2;

public class Solution {

    public static void main(String[] args) {
        int i = new Solution().climbStairs(5);
        System.out.println(i);
    }

    //通过递推得出状态转移方程
    public int climbStairs(int n) {
        int p = 0;
        int q = 0;
        int r = 1;
        for (int i = 0; i < n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
