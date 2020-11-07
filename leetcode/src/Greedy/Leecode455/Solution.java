package Greedy.Leecode455;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] g = {1,2,3};
        int[] s = {1,1};
        int ans = new Solution().findContentChildren(g,s);
        System.out.println(ans);
    }
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int gi = 0;
        int si = 0;
        while(gi < g.length && si < s.length){
            if(g[gi] <= s[si]){
                gi++;
            }
            si++;
        }
        return gi;
    }
}
