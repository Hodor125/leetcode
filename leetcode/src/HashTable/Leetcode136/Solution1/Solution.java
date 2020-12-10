package HashTable.Leetcode136.Solution1;

import java.util.Arrays;

/**
 * @author ：hodor007
 * @date ：Created in 2020/12/10
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public int singleNumber(int[] nums) {
        if(nums.length < 2){
            return nums[0];
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int len = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if(i == 0){
                if(nums[i] != nums[i + 1]){
                    return nums[i];
                }
            }
            if(i > 0 && nums[i] != nums[i - 1]){
                if(i + 1 < len){
                    if(nums[i] != nums[i + 1]){
                        return nums[i];
                    }
                } else if(i == len - 1){
                    return nums[i];
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
//        int[] nums = {1,1,1,2,2,3,4,4,4,5,5};
        int[] nums = {2,2,1};
        Solution solution = new Solution();
        int ans = solution.singleNumber(nums);
        System.out.println(ans);
    }
    //112234455
}
