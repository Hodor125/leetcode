package Array;

/*
递减元素使得数组呈现锯齿状

解法：
    暴力解法，两种情况各自算，取较小值,需要注意边界值只有一边的情况
 */
public class Leecode_1144 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{10,4,4,10,10,6,2,3};
        System.out.println(s.movesToMakeZigzag(nums));
    }
}

class Solution {
    public int movesToMakeZigzag(int[] nums) {
        int n = nums.length;
        int ans1 = 0,ans2 = 0;
        for (int i = 0; i < n; i++) {
            int left = (i > 0 && nums[i] >= nums[i - 1]) ? (nums[i] - nums[i - 1] + 1) : 0;
            int right = (i + 1 < n && nums[i] >= nums[i + 1]) ? nums[i] - nums[i + 1] + 1 : 0;
            int ans = Math.max(left, right);
            if(i % 2 == 0){
                ans1 += ans;//偶数大的情况
//                System.out.println("ans1+ " + ans);
            }
            else{
                ans2 += ans;//奇数大的情况
//                System.out.println("ans2+ " + ans2);
            }
        }
//        System.out.println("ans1:" + ans1 + ",ans2:" + ans2);
        return Math.min(ans1, ans2);
    }
}