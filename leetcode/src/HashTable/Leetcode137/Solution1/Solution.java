package HashTable.Leetcode137.Solution1;

import java.util.HashSet;

/**
 * @author ：hodor007
 * @date ：Created in 2020/12/10
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public int singleNumber(int[] nums) {
        long total = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            total += nums[i];
        }
        long sum = 0;
        for (Integer integer : set) {
            sum += integer;

        }
        return (int) ((sum * 3  - total) / 2);
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,1,2,4,4,3,4};
        Solution solution = new Solution();
        int ans = solution.singleNumber(nums);
        System.out.println(ans);
    }
}
