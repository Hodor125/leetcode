package DoublePointer;

import java.util.Arrays;

/**
 * @author ：hodor007
 * @date ：Created in 2021/4/7
 * @description ：
 * @version: 1.0
 */
class Solution {
    public int purchasePlans(int[] nums, int target) {
        int mod = 1000000007;
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int sum = 0;
        while(left < right) {
            if(nums[left] + nums[right] > target) {
                right--;
            } else {
                sum += right - left;
                sum %= mod;
                left++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {2,5,3,5};
        Solution solution = new Solution();
        int num = solution.purchasePlans(nums, 6);
        System.out.println(num);
    }
}
