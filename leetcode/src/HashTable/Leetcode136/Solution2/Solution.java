package HashTable.Leetcode136.Solution2;

/**
 * 官方题解，好像结果是错的
 * @author ：hodor007
 * @date ：Created in 2020/12/10
 * @description ：
 * @version: 1.0
 */
class Solution {
    public int singleNumber(int[] nums) {
        int single = nums[0];
        for (int i = 1; i < nums.length; i++) {
            single ^= nums[i];
        }
        return single;
    }



    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,4,4};
        Solution solution = new Solution();
        int ans = solution.singleNumber(nums);
        System.out.println(ans);
    }
}


