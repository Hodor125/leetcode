package Math.Leetcode9.Solution2;

import java.util.ArrayList;

/**
 * 还是使用了额外的空间
 */
public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;

        //手动算每一位存在list中
        ArrayList<Integer> list = new ArrayList<Integer>();
        int quotient = 0;
        int remain = 0;
        do{
            quotient = x / 10;
            remain = x % 10;
            list.add(remain);
            x = x / 10;
        }while(quotient != 0);

        //双指针判断首尾指针是否相等，不相等则返回false
        int l = 0;
        int r = list.size() - 1;
        while(l < r){
            if(list.get(l) != list.get(r))
                return false;
            l++;
            r--;
        }

        return true;
    }

    public static void main(String[] args) {
        int num = 1231;
        Solution solution = new Solution();
        boolean ans = solution.isPalindrome(num);
        System.out.println(ans);
    }
}
