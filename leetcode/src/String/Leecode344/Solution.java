package String.Leecode344;

import Array.Leecode509.Solution2;

public class Solution {
    public static void main(String[] args) {
        char[] arr = null;
        new Solution().reverseString(arr);

        if(arr == null)
            System.out.println("null");
        else
            System.out.println(arr);
    }

    public void reverseString(char[] s) {
        if(s == null || s.length == 0)
            return;

        int l = 0;
        int r = s.length - 1;
        while(l < r){
            char t = s[l];
            s[l] = s[r];
            s[r] = t;
            l++;
            r--;
        }
    }
}
