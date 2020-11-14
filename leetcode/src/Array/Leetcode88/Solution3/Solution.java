package Array.Leetcode88.Solution3;

import java.util.Arrays;

/**
 * @author ：hodor007
 * @date ：Created in 2020/11/13
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n){
        int len = nums1.length - 1;
        m--;
        n--;

        while(len >= 0){
            if(m >=0 && n >= 0){
                if(nums1[m] > nums2[n]){
                    nums1[len] = nums1[m];
                    len--;
                    m--;
                } else {
                    nums1[len] = nums2[n];
                    len--;
                    n--;
                }
                continue;
            }
            if(m >= 0){
                nums1[len] = nums1[m];
                len--;
                m--;
            }

            if(n >= 0){
                nums1[len] = nums2[n];
                len--;
                n--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 0, 0, 0};
        int[] arr2 = {2, 5, 6};
        Solution solution = new Solution();
        solution.merge(arr1,3,arr2,3);
        System.out.println(Arrays.toString(arr1));
    }
}
