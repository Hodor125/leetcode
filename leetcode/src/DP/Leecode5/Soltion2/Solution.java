package DP.Leecode5.Soltion2;

public class Solution {
    /**
     * 暴力枚举法，三重循环
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if(s.length() == 1)
            return s;

        int len = s.length();
        int maxlen = 0;
        String ans = "";
        //最后一个位置没必要枚举了
        for (int i = 0; i < len - 1; i++) {
            for (int j = i; j < len; j++) {
                //进行剪枝操作
                if((j - i + 1) > maxlen && judge(s, i, j)){
                    maxlen = j - i + 1;
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;
    }

    //判断回文串
    public boolean judge(String s,int l,int r){
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String ans = solution.longestPalindrome("a");
        System.out.println(ans);
    }
}
