package DP.Leecode474;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String[] arr = {"10", "0001", "111001", "1", "0"};
        Solution s = new Solution();


        int ans = s.findMaxForm3(arr,5,3);
        System.out.println(ans);
    }

    private int[] countZeroAndOne(String str) {
        int[] cnt = new int[2];
        for (char c : str.toCharArray()) {
            cnt[c - '0']++;
        }
        return cnt;
    }

    //liweiwei
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len + 1][m + 1][n + 1];

        for (int i = 1; i <= len; i++) {
            // 注意：有一位偏移
            int[] cnt = countZeroAndOne(strs[i - 1]);
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    // 先把上一行抄下来
                    dp[i][j][k] = dp[i - 1][j][k];

                    int zeros = cnt[0];
                    int ones = cnt[1];

                    if (j >= zeros && k >= ones) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zeros][k - ones] + 1);
                    }
                }
            }
        }
        return dp[len][m][n];
    }


    //官方题解
    /*
    增加了一行一列考虑到了只剩下一种字符的情况
    难点在于设计出状态（本质上是暴力遍历）
     */
    public int findMaxForm2(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String s: strs) {
            int[] count = countzeroesones(s);
            //使用各种数量的字符进行拼接的结果
            //循环中进行了判断，字符数量不够则不会执行，不存在数组越界的情况
            for (int zeroes = m; zeroes >= count[0]; zeroes--)
                for (int ones = n; ones >= count[1]; ones--)
                    //选择这个字符串和不选择这个字符串
                    dp[zeroes][ones] = Math.max(1 + dp[zeroes - count[0]][ones - count[1]], dp[zeroes][ones]);
        }
        return dp[m][n];
    }
    public int[] countzeroesones(String s) {
        int[] c = new int[2];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i)-'0']++;
        }
        return c;
    }

    public int findMaxForm3(String[] strs, int m, int n){
        int[][] dp = new int[m+1][n+1];

        for (String str : strs) {
            int[] count = findZerosOnes(str);
            for(int i = m; i >= count[0]; i--){
                for(int j = n; j >= count[1]; j--){
                    dp[i][j] = Math.max(1+dp[i - count[0]][j - count[1]],dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }

    public int[] findZerosOnes(String s){
        char[] arr = s.toCharArray();
        int[] res = new int[2];
        for (char c : arr) {
            res[c - '0']++;
        }
        return res;
    }
}