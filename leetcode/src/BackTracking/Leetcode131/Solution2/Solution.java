package BackTracking.Leetcode131.Solution2;

import com.sun.javafx.css.PseudoClassState;
import com.sun.org.apache.bcel.internal.generic.FSUB;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 使用动态规划进行优化
 * @author ：hodor007
 * @date ：Created in 2020/12/20
 * @description ：
 * @version: 1.0
 */
public class Solution {
    private boolean[][] dp;
    public List<List<String>> partition(String s) {
        int len = s.length();
        dp = new boolean[len][len];

        List<List<String>> res = new ArrayList<>();
        ArrayDeque<String> stack = new ArrayDeque<>();

        //特判
        if(s == null || s.length() == 0){
            return res;
        }

        //预处理判断不同长度的字符串是否是回文串
        for (int i = 0; i < len; i++) {
            for (int j = 0; j + i < len; j++) {
                int k = j + i;
                if(i == 0){
                    dp[j][k] = true;
                } else if (i == 1){
                    dp[j][k] = s.charAt(j) == s.charAt(k);
                } else {
                    dp[j][k] = s.charAt(j) == s.charAt(k) && dp[j + 1][k - 1];
                }
            }
        }

        backtracking(0, s, res, stack);

        return res;
    }

    private void backtracking(int start, String s, List<List<String>> res, ArrayDeque<String> subAns){
        if(start == s.length()){
            res.add(new ArrayList<>(subAns));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if(dp[start][i]){
                subAns.addLast(s.substring(start, i + 1));
                backtracking(i + 1, s, res, subAns);
                subAns.pollLast();
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> ans = solution.partition("aab");
        for (List<String> an : ans) {
            System.out.println(an);
        }
    }
}
