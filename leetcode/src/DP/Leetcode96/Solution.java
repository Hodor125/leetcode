package DP.Leetcode96;

/**
 * 主要还是推导，不要被吓住了
 * @author ：hodor007
 * @date ：Created in 2020/11/20
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public int numTrees(int n) {
        if(n == 1 ||  n == 0)
            return 1;
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int ans = solution.numTrees(3);
        System.out.println(ans);
    }
}
