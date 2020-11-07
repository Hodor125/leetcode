package Array.Leetcode11.Solution2;

public class Solution {
    /*
    面积受限于长度和宽度
    在暴力法中固定了一边，只移动另一边，长度和宽度同时变化，每一次都需要计算
    双指针从左右向中间进行迭代，长度是减少的，只有宽度变大才面积可能变大
    而面积受限于较短的一边，所以要移动较短的一边才可能使面积变大
     */
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max_capacity = 0;
        while(l < r){
            int capacity = (r - l) * Math.min(height[l], height[r]);
            max_capacity = Math.max(capacity,max_capacity);

            if(height[l] < height[r])
                l++;
            else
                r--;
        }
        return max_capacity;
    }

    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        Solution solution = new Solution();
        int ans = solution.maxArea(arr);
        System.out.println(ans);
    }
}
