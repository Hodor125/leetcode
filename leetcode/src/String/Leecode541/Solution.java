package String.Leecode541;

import Array.Leecode509.Solution2;

public class Solution {
    public static void main(String[] args) {
        String str = "abcdefg";
        String s = new Solution().reverseStr(str,2);
        System.out.println(s);
    }

    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        for (int start = 0; start < arr.length; start += 2*k) {
            int i = start;
            int j = Math.min(i + k - 1,arr.length - 1);
            while(i < j){
                char t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                i++;
                j--;
            }
        }
        return new String(arr);
    }
}
