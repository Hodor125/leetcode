package HashTable.Leecode128;

import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args) {
        int[] arr = {1,2,0,1};
        int ans = new Solution1().longestConsecutive(arr);
        System.out.println(ans);
    }

    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        Arrays.sort(nums);

        int count = 1;
        int max_len = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1] + 1)
                count++;
            else if(nums[i] == nums[i - 1]){

            } else {
                max_len = max_len > count ? max_len : count;
                count = 1;
            }
        }
        max_len = max_len > count ? max_len : count;
        return max_len;
    }
}
