package Array.Leetcode64;

/**
 * @author ：hodor007
 * @date ：Created in 2020/10/31
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if(i == 0){
                    //第一行的情况
                    if(j != 0){
                        grid[i][j] = grid[i][j] + grid[i][j - 1];
                    }
                } else {
                    //第一列的情况
                    if(j == 0){
                        grid[i][j] = grid[i][j] + grid[i - 1][j];
                    } else {
                        grid[i][j] = Math.min(grid[i][j] + grid[i - 1][j],grid[i][j] + grid[i][j - 1]);
                    }
                }
            }
        }
        return grid[row - 1][column - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };

        Solution solution = new Solution();
        int ans = solution.minPathSum(grid);
        System.out.println(ans);
    }
}
