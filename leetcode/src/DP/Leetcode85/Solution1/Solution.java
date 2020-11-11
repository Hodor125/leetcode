package DP.Leetcode85.Solution1;

/**
 * @author ：hodor007
 * @date ：Created in 2020/11/11
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int maxValue = 0;
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        int[][] temp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(j == 0){
                    if(matrix[i][j] == '1'){
                        dp[i][j] = 1;
                    }
                } else {
                    if(matrix[i][j] == '1'){
                        dp[i][j] = dp[i][j - 1] + 1;
                    } else {
                        dp[i][j] = 0;
                    }
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                //寻找当前点为右下角的最大矩阵
//                int subMax = 0;
                if(matrix[i][j] == '1'){
                    int width = dp[i][j];
                    for(int k = 1; i - k + 1 >= 0; k++){
                        width = Math.min(width,dp[i - k + 1][j]);
                        int area = k * width;
                        maxValue = Math.max(maxValue,area);
//                        subMax = Math.max(subMax,area);
                    }
                }
//                temp[i][j] = subMax;
            }
        }
//        System.out.println("dp:");
//        for (int[] ints : dp) {
//            System.out.println(Arrays.toString(ints));
//        }
//        System.out.println("temp:");
//        for (int[] ints : temp) {
//            System.out.println(Arrays.toString(ints));
//        }
        return maxValue;
    }

    public static void main(String[] args) {
        char [][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        Solution solution = new Solution();
        int ans = solution.maximalRectangle(matrix);
        System.out.println(ans);
    }
}
