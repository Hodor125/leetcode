package Array.Leecode189;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {1,2};
        s.rotate(arr,0);
    }
    public void rotate(int[] nums, int k) {
        //排除特例
        if(nums == null || nums.length == 0 || nums.length == 1)
            return;

        int num = k % nums.length;

        //排除特例
        if(num == 0)
            return;
        reverse(nums,0,nums.length - 1);
        reverse(nums,0,num - 1);
        reverse(nums,num,nums.length - 1);
//        System.out.println(Arrays.toString(nums));
    }

    public void reverse(int[] nums,int l,int r){
        int mid = l + (r - l) / 2 + 1;
        for (int i = l; i < mid; i++) {
            int temp = nums[i];
            nums[i] = nums[l + r -i];
            nums[l + r - i] = temp;
        }
    }
}




