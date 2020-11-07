package Array.Leetcode27.Solution2;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while(i < n){
            //如果当前的数等于目标数，把右指针的数挪过来替换
            if(nums[i] == val){
                n--;
                nums[i] = nums[n];
            } else {
                //当前的数不等于目标数，左指针向右移动
                i++;
            }
        }

        return n;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,2,2,3,0,4,2};
        Solution solution = new Solution();
        int ans = solution.removeElement(arr, 2);
        System.out.println(ans);
    }
}
