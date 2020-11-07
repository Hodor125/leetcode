package Array.Leetcode75.Solution1;

import java.util.Arrays;

public class Solution {
    public void sortColors(int[] nums) {
        int zeros = 0;
        int ones = 0;
        int twos = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0)
                zeros++;
            if(nums[i] == 1)
                ones++;
            if(nums[i] == 2)
                twos++;
        }
        for (int i = 0; i < zeros; i++) {
            nums[i] = 0;
        }
        for (int i = zeros; i < ones + zeros; i++) {
            nums[i] = 1;
        }
        for (int i = ones + zeros; i < twos + ones + zeros; i++) {
            nums[i] = 2;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0,2,1,1,2,0,0,1};
        Solution solution = new Solution();
        solution.sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }
}
