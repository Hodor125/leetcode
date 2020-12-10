package DP.Leetcode139.Solution2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author ：hodor007
 * @date ：Created in 2020/12/9
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int len = s.length() + 1;
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                String substring = s.substring(j, i);
                if(dp[j] && set.contains(substring)){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        String str = "applepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        Solution solution = new Solution();
        boolean ans = solution.wordBreak(str, wordDict);
        System.out.println(ans);
    }
}
