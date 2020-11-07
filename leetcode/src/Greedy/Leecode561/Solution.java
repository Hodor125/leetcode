package Greedy.Leecode561;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1,5,3,6};
        Solution s = new Solution();
        int sum = s.arrayPairSum(arr);
        System.out.println(sum);
    }
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        System.out.println(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i % 2 == 0)
                sum += nums[i];
        }
        return sum;
    }
}
