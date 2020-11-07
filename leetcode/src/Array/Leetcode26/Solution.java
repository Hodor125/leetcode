package Array.Leetcode26;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;

        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[j]){
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        Solution solution = new Solution();
        int ans = solution.removeDuplicates(arr);
        System.out.println(ans);
    }
}
