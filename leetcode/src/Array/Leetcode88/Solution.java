package Array.Leetcode88;

import java.util.Arrays;

/**
 * 暴力法
 * @author ：hodor007
 * @date ：Created in 2020/11/13
 * @description ：
 * @version: 1.0
 */
public class Solution {
    /**
     * @param nums1 c长数组
     * @param m
     * @param nums2 短数组
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = nums1.length;  //长数组
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < len; j++) {
                if(j < m){
                    if (nums2[i] < nums1[j]) {
                        add(nums1, j, nums2[i]);
                        m++;
                        break;
                    }
                } else {
                    nums1[j] = nums2[i];
                    m++;
                    break;
                }
            }
        }
    }

    private void add(int[] nums, int idx, int target) {
        for (int i = nums.length - 1; i > idx; i--) {
            nums[i] = nums[i - 1];
        }
        nums[idx] = target;
    }

    public static void main(String[] args) {
        int[] arr1 = {0, 0, 0};
        int[] arr2 = {2, 5, 6};
        Solution solution = new Solution();
        solution.merge(arr1, 0, arr2, 3);
        System.out.println(Arrays.toString(arr1));
    }
}
