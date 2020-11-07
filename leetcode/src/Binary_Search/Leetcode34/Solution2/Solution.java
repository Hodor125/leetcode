package Binary_Search.Leetcode34.Solution2;

import java.util.Arrays;

/**
 * 二分查找，两次查找边界值
 *
 * 测试用例：
 * 0,1,2,3,4,5,6,7,8,9
 * 5,7,7,7,7,7,8,8,8,10
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return new int[]{-1, -1};

        int len = nums.length;
        int left = 0;
        int right = 0;
        int l = 0;
        int r = nums.length - 1;

        //寻找左边界，如果
        while(l < r){
            int mid = l + (r - l) / 2;
            if(nums[mid] < target){
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        left = l;

        l = 0;
        r = nums.length - 1;
        while(l < r){
            int mid = l + (r - l) / 2;
            if(nums[mid] <= target){
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        if(r > 0 && nums[r] != target)
            right = r - 1;
        else
            right = r;

        if(nums[left] != target)
            return new int[]{-1, -1};

        return new int[]{left,right};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2};
        System.out.println(nums.length);
        Solution solution = new Solution();
        int[] ans = solution.searchRange(nums, 2);
        System.out.println(Arrays.toString(ans));
    }
}
