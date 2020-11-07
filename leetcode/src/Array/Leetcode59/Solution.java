package Array.Leetcode59;

import java.util.Arrays;

/**
 * @author ：hodor007
 * @date ：Created in 2020/10/31
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int left = 0;
        int top = 0;
        int bottom = n - 1;
        int right = n - 1;
        int total = n * n;
        int count = 0;

        while(count < total){
            for (int i = left; i <= right; i++) {
                matrix[top][i] = count + 1;
                count++;
            }
            for (int i = top + 1; i <= bottom; i++) {
                matrix[i][right] = count + 1;
                count++;
            }
            for (int i = right - 1; i >= left + 1; i--) {
                matrix[bottom][i] = count + 1;
                count++;
            }
            for (int i = bottom; i >= top + 1; i--) {
                matrix[i][left] = count + 1;
                count++;
            }
            left++;
            right--;
            top++;
            bottom--;
        }

        return matrix;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] ans = solution.generateMatrix(2);
        for (int[] an : ans) {
            System.out.println(Arrays.toString(an));
        }
    }
}
