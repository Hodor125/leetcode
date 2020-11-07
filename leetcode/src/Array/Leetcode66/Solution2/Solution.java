package Array.Leetcode66.Solution2;

import java.util.Arrays;

/**
 * @author ：hodor007
 * @date ：Created in 2020/10/31
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int i = 0;
        for (i = len - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if(digits[i] != 0)
                return  digits;
        }
        int[] ints = new int[digits.length + 1];
        ints[0] = 1;
        return ints;
    }

    public static void main(String[] args) {
        int[] num = {8,9,9};
        Solution solution = new Solution();
        int[] ans = solution.plusOne(num);
        System.out.println(Arrays.toString(ans));
    }
}
