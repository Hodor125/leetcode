package Array.Leecode485;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1,1,0,1,1,1};
        Solution s = new Solution();
        int oneNum = s.findMaxConsecutiveOnes(arr);
        System.out.println(oneNum);
    }

    public int findMaxConsecutiveOnes(int[] nums) {

        if(nums == null || nums.length == 0)
            return 0;

        int count = 0,num = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 1)
                count++;
            else{
                num = num > count ? num : count;
                count = 0;
            }
        }
        num = num > count ? num : count;
        return num;
    }
}
