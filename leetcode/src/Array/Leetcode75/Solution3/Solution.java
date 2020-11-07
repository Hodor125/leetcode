package Array.Leetcode75.Solution3;

import java.util.Arrays;


public class Solution {

    public void sortColors(int[] nums) {
        //all in [0,zeros) = 0
        //all in [zeros,i) = 1
        //all in [twos,len - 1] = 2

        //初始的三个区间都没有数
        int len = nums.length;
        int zeros = 0;
        int twos = len;
        int i = 0;

        while(i < twos){
            if(nums[i] == 0){
                swap(nums,i,zeros);
                i++;
                zeros++;
            } else if(nums[i] == 1){
                i++;
            } else {
                twos--;
                swap(nums,twos,i);
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {0,2,1,1,2,0,0,1};
//        int[] arr = {1,0};
        Solution solution = new Solution();
        solution.sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }
}
