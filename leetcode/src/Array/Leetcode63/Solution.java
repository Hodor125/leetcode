package Array.Leetcode63;

/**
 * @author ：hodor007
 * @date ：Created in 2020/11/1
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int columns = obstacleGrid[0].length;

        //特判
        //起始点（？？？）和终点（？？？）有障碍时没有路径[题出的真有毛病]
        if(obstacleGrid[rows - 1][columns - 1] == 1)
            return 0;

        if(obstacleGrid[0][0] == 1)
            return 0;

        //把1替换为-1
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(obstacleGrid[i][j] == 1){
                    obstacleGrid[i][j] = -1;
                }
            }
        }
        obstacleGrid[0][0] = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(i == 0){
                    //第一行的情况
                    if(j != 0){
                        if(obstacleGrid[i][j] == -1){

                        } else if(obstacleGrid[i][j - 1] == -1){
                            obstacleGrid[i][j] = 0;
                        } else {
                            obstacleGrid[i][j] = obstacleGrid[i][j - 1];
                        }
                    }
                } else {
                    //第一列的情况
                    if(j == 0){
                        if(obstacleGrid[i][j] == -1){

                        } else if(obstacleGrid[i - 1][j] == -1){
                            obstacleGrid[i][j] = 0;
                        } else {
                            obstacleGrid[i][j] = obstacleGrid[i - 1][j];
                        }
                    } else {
                        if(obstacleGrid[i][j] == -1){

                        } else if(obstacleGrid[i - 1][j] == -1){
                            //一边被堵上
                            if(obstacleGrid[i][j - 1] == -1){
                                //两边被堵上
                                obstacleGrid[i][j] = 0;
                            } else {
                                obstacleGrid[i][j] = obstacleGrid[i][j - 1];
                            }
                        } else if(obstacleGrid[i][j - 1] == -1){
                            //一边被堵上
                            obstacleGrid[i][j] = obstacleGrid[i - 1][j];
                        } else {
                            obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                        }
                    }
                }
            }
        }
        return obstacleGrid[rows - 1][columns - 1];
    }

    public static void main(String[] args) {
//        int[][] obstacleGrid = {
//                {0,0,0,0,0,0,0},
//                {0,0,-1,0,0,0,0,0},
//                {0,0,0,0,0,0,0}
//        };

//        int[][] obstacleGrid = {
//                {0,1},
//                {1,0}
//        };

//        int[][] obstacleGrid = {
//                {1}
//        };

//        int[][] obstacleGrid = {
//                {0}
//        };

        int[][] obstacleGrid = {
                {0,1}
        };
        Solution solution = new Solution();
        int ans = solution.uniquePathsWithObstacles(obstacleGrid);
        System.out.println(ans);
    }
}
