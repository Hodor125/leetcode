package Array.Leetcode62;

/**
 * @author ：hodor007
 * @date ：Created in 2020/10/31
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];
        matrix[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0){
                    //第一行
                    if(j != 0){
                        matrix[i][j] = matrix[i][j - 1];
                    }
                } else {
                    //第一列
                    if(j == 0){
                        matrix[i][j] = matrix[i - 1][j];
                    } else {
                        matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
                    }
                }
            }
        }
        return matrix[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int ans = solution.uniquePaths(7, 3);
        System.out.println(ans);
    }
}
