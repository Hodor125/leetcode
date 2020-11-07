package Array.Leetcode11.Solution1;

public class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        int max_capacity = 0;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int capacity = (j - i) * Math.min(height[i], height[j]);
                max_capacity = Math.max(max_capacity,capacity);
            }
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
