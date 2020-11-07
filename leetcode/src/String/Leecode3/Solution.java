package String.Leecode3;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        String str = "pwwkew";
        int len = new Solution().lengthOfLongestSubstring(str);
        System.out.println(len);
    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int rk = -1;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if(i != 0)
                set.remove(s.charAt(i));//自动解包装

            while(rk + 1 < s.length() && !set.contains(s.charAt(rk + 1))){
                set.add(s.charAt(rk + 1));
                rk++;
            }
            ans = Math.max(ans,rk - i + 1);
        }
        return ans;
    }
}
