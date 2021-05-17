package DP.Leecode5.Solution2;

/**
 * @author ：hodor007
 * @date ：Created in 2021/3/28
 * @description ：
 * @version: 1.0
 */
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        int l = 0;
        int r = 0;
        int max = 0;
        boolean[][] flags = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j + i < len; j++) {
                int k = j + i;
                if(i == 0) {
                    flags[j][k] = true;
                } else if(i == 1) {
                    flags[j][k] = s.charAt(j) == s.charAt(k);
                } else {
                    flags[j][k] = flags[j + 1][k - 1] && s.charAt(j) == s.charAt(k);
                }

                if(flags[j][k] && i > max) {
                    l = j;
                    r = k;
                    max = i;
                }
            }
        }
        return s.substring(l, r + 1);
    }

    public static void main(String[] args) {
        String str = "bb";
        Solution solution = new Solution();
        String ans = solution.longestPalindrome(str);
        System.out.println(ans);
    }
}