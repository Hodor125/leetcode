package Array.Leetcode80;

import java.util.Arrays;

/**
 * @author ：hodor007
 * @date ：Created in 2020/11/8
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return 1;

        int i = 1;
        int count = 1;
        int len = nums.length;
        //长度为1的情况？
        while(i < len){
            if(nums[i] == nums[i - 1]){
                count ++;
            } else {
                count = 1;
            }

            if(count > 2){
                removeNum(nums,i);
                len --;
            } else {
                i ++;
            }
        }

        return len;
    }

    private void removeNum(int[] nums, int index){
        for (int i = index; i < nums.length - 1; i++) {
            nums[i] = nums[i + 1];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,2,3,3,4,5,5,5,5,6};
        Solution solution = new Solution();
        int ans = solution.removeDuplicates(nums);
        System.out.println(ans);
    }
}
