package Binary_Search.Leetcode34.Solution1;

import java.util.Arrays;

/**
 * 线性时间复杂度
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return new int[]{-1, -1};

        int l = 0;
        int r = nums.length - 1;
        while(l < r){
            if(nums[l] < target){
                l++;
            }

            if(nums[r] > target){
                r--;
            }

            if(nums[l] >= target && nums[r] <= target)
                break;
        }

        if(nums[l] == target)
            return new int[]{l , r};

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        Solution solution = new Solution();
        int[] ans = solution.searchRange(nums, 8);
        System.out.println(Arrays.toString(ans));
    }
}
