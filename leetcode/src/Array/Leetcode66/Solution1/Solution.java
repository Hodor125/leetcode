package Array.Leetcode66.Solution1;

import java.util.Arrays;

/**
 * @author ：hodor007
 * @date ：Created in 2020/10/30
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int i = len - 1;
        int carry = 1;
        while(i >= 0 && carry == 1){
            if(i == 0){
                //进位到了最高位，用新的数组存储
                if(digits[i] == 9){
                    digits[i] = 0;
                    int[] newDigits = new int[len + 1];
                    newDigits[0] = 1;
                    for (int j = 1; j < len + 1; j++) {
                        newDigits[j] = digits[j - 1];
                    }
                    return newDigits;
                } else {
                    digits[i] = digits[i] + 1;
                    break;
                }
            }

            carry = 0;
            if(digits[i] + 1 > 9){
                digits[i] = 0;
                carry = 1;
                i--;
            } else {
                digits[i]++;
            }
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] num = {8,9,9};
        Solution solution = new Solution();
        int[] ans = solution.plusOne(num);
        System.out.println(Arrays.toString(ans));
    }
}
