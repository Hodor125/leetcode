package Math.Leetcode9.Solution1;

public class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int l = 0;
        int r = s.length() - 1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        int num = 121;
        Solution solution = new Solution();
        boolean ans = solution.isPalindrome(num);
        System.out.println(ans);
    }
}
