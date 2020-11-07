package Math.Leetcode48;

import java.util.Arrays;

/**
 * @author ：hodor007
 * @date ：Created in 2020/10/28
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        int l = 0;
        int r = len - 1;
        while(l < r){
            for (int i = 0; i < len; i++) {
                int temp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = temp;
            }
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
        };
        Solution solution = new Solution();
        solution.rotate(matrix);
        System.out.println("==========3===========");
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
