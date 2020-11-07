package Greedy.Leecode409;

public class Solution {
    public static void main(String[] args) {
        String str = "abccccdd";
        int i = new Solution().longestPalindrome(str);
        System.out.println(i);
    }

    public int longestPalindrome(String s) {

        int[] signs = new int[128];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            signs[ch]++;
        }

        int len = 0;
        for (int i = 0; i < signs.length; i++) {
            len += signs[i] / 2 * 2;
            if(len % 2 == 0 && signs[i] % 2 == 1)
                len++;
        }
        return len;
    }
}
