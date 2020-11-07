package String.Leetcode344;

public class Solution {
    public void reverseString(char[] s) {
        if(s == null || s.length == 0)
            return;

        int l = 0;
        int r = s.length - 1;
        while(l < r){
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        Solution solution = new Solution();
        solution.reverseString(s);
        System.out.println(s);
    }
}
