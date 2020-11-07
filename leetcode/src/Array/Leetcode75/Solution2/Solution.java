package Array.Leetcode75.Solution2;

import java.util.Arrays;

/**
 * 两趟扫描算法
 */
public class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        int ptr = 0;
        //能不能行调试了才知道，瞎想没用
        for (int i = 0; i < len; i++) {
            if(nums[i] == 0){
                int temp = nums[ptr];
                nums[ptr] = 0;
                nums[i] = temp;
                ptr++;
            }
        }

        for (int i = ptr; i < len; i++) {
            if(nums[i] == 1){
                int temp = nums[ptr];
                nums[ptr] = 1;
                nums[i] = temp;
                ptr++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {0,2,1,1,2,0,0,1};
        Solution solution = new Solution();
        solution.sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }
}
