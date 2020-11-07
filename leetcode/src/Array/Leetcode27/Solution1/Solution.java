package Array.Leetcode27.Solution1;

public class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0)
            return 0;

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val){
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,2,2,3,0,4,2};
        Solution solution = new Solution();
        int ans = solution.removeElement(arr,2);
        System.out.println(ans);
    }
}
