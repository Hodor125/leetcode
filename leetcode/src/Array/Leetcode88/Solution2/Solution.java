package Array.Leetcode88.Solution2;

import java.util.Arrays;

/**
 * 借用额外空间有何不可，现在空间不值钱
 *
 * @author ：hodor007
 * @date ：Created in 2020/11/13
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] _m = Arrays.copyOf(nums1,m);
        int idx = 0;
        int l1 = 0;
        int l2 = 0;
        while(l1 < m && l2 < n){
            if(_m[l1] < nums2[l2]){
                nums1[idx] = _m[l1];
                l1++;
                idx++;
            } else {
                nums1[idx] = nums2[l2];
                l2++;
                idx++;
            }
        }
        while(l1 < m){
            nums1[idx] = _m[l1];
            l1++;
            idx++;
        }
        while(l2 < n){
            nums1[idx] = nums2[l2];
            l2++;
            idx++;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 0, 0, 0};
        int[] arr2 = {2, 5, 6};
        Solution solution = new Solution();
        solution.merge(arr1, 3, arr2, 3);
        System.out.println(Arrays.toString(arr1));
    }
}
