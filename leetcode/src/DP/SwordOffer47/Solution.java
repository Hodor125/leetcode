package DP.SwordOffer47;

public class Solution {
    public int maxValue(int[][] grid) {
        //正常遍历即可，要勇于尝试，不要就脑补什么复杂遍历方法
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(i == 0 && j == 0){
                    //什么都不做，保持原数值
                }
                if(i == 0 && j > 0){
                    //边界情况
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                }
                if(i > 0 && j == 0){
                    //边界情况
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                }
                if(i > 0 && j > 0){
                    grid[i][j] = Math.max(grid[i - 1][j] + grid[i][j],grid[i][j - 1] + grid[i][j]);
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };

        Solution solution = new Solution();
        int ans = solution.maxValue(arr);
        System.out.println(ans);
    }
}
