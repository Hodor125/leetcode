package Array.Leetcode16;

import java.util.Arrays;

/**
 * 类似Leetcode15三数之和
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;

        int ans = 10001;

        //外循环遍历数组
        for (int i = 0; i < len; i++) {
            int l = i + 1;
            int r = len - 1;

            //循环终止的条件，内循环双指针寻找答案
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                ans = Math.abs(ans - target) >= Math.abs(sum - target) ? sum : ans;
                //三数和大于目标则右指针左移
                if(sum > target)
                    r--;
                //三数和小于目标则左指针右移
                else if(sum < target)
                    l++;
                //三数和等于目标则直接返回
                else if(sum == target)
                    return target;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,8,16,32,64,128};
        Solution solution = new Solution();
        int ans = solution.threeSumClosest(arr, 82);
        System.out.println(ans);
    }
}
