package Array.Leetcode31;

import java.util.Arrays;

//关键在于如何理解字典序，其实意思就是找到比这个数大的最小的一个数
public class Solution {
    public void nextPermutation(int[] nums) {
        //特判
        if (nums == null || nums.length == 0 || nums.length == 1)
            return;

        //从后往前找到递增的两个数(i,j)
        int len = nums.length - 1;
        int i = 0;
        for (i = len; i > 0 ; i--) {
            if(nums[i] > nums[i - 1]){
                i--;
                break;
            }
        }

        //已经是最大数了，全部逆序
        if(i == 0 && nums[i] > nums[i + 1]){
            int l = 0;
            int r = len;
            while(l < r){
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
                r--;
            }
            return;
        }

        //考虑边界情况
        //交换(i与(j,end)的某个数交换)
        int j = i + 1;
        int k = 0;//找到最逼近nums[i]的数
        for (k = len; k >= j; k--) {
            if(nums[k] > nums[i])
                break;
        }
        int temp = nums[i];
        nums[i] = nums[k];
        nums[k] = temp;

        //逆序(将(j,end)逆序)
        int l = j;
        int r = len;
        while(l < r){
            temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
//        int[] num = {1,2,3,4,5,6};
//        int[] num = {6,5,4,3,2,1};
//        int[] num = {1,3,2};
        int[] num = {1,2};
        Solution solution = new Solution();
        solution.nextPermutation(num);
        System.out.println(Arrays.toString(num));
    }
}
