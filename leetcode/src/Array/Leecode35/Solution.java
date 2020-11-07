package Array.Leecode35;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6};
        int num = 5;
        int ans = searchInsert(arr, num);
        System.out.println(ans);
    }

    public static int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if(nums[m] < target)
                l = m + 1;
            else
                r = m - 1;
        }
        return l;
    }
}
