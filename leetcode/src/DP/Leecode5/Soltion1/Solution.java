package DP.Leecode5.Soltion1;


public class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        //flag[i][j] = true表示从下标i到j的字串是回文串
        boolean[][] flag = new boolean[len][len];
        String ans = "";

        //从短的字符串递推到长的字符串
        for (int l = 0; l < len; l++) {
            for (int i = 0; i + l < len; i++) {
                //判断这个l + 1长度的字串是否是回文串
                int j = i + l;
                if(l == 0){
                    //长度为1的字符串显然是回文串
                    flag[i][j] = true;
                }else if(l == 1){
                    //长度为2的字符串判断两个字符是否相等
                    if(s.charAt(i) == s.charAt(j)){
                        flag[i][j] = true;
                    }
                }else{
                    //下边i + 1到j - 1的字串是否是回文串已经判断过了，如果为true且首尾字符相同
                    // 则这个字串是回文串
                    if(flag[i + 1][j - 1] && s.charAt(i) == s.charAt(j)){
                        flag[i][j] = true;
                    }
                }

                //取最长的结果
                if(flag[i][j] && l + 1 > ans.length())
                    ans = s.substring(i, i + l + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String ans = solution.longestPalindrome("babad");
        System.out.println(ans);
    }
}
