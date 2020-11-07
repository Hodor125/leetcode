package Array.Leetcode73.Solution2;

import java.util.Arrays;

/**
 * 记忆化（标记法）
 * @author ：hodor007
 * @date ：Created in 2020/11/3
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        int[] flag = new int[2];
        int rows = matrix.length;
        int columns= matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                    //判断第一行有数字为0，matrix[0][0]的情况
                    if(i == 0){
                        flag[0] = 1;
                    }
                    if(j == 0){
                        flag[1] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            if(matrix[i][0] == 0){
                if(i == 0 && flag[0] == 0){
                    continue;
                }
                for (int j = 0; j < columns; j++) {
                    if(matrix[i][j] != 0)
                        matrix[i][j] = -100000;
                }
            }
        }

        for (int i = 0; i < columns; i++) {
            if(i == 0 && flag[1] == 0){
                continue;
            }
            if(matrix[0][i] == 0){
                for (int j = 0; j < rows; j++) {
                    if(matrix[j][i] != 0)
                        matrix[j][i] = -100000;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(matrix[i][j] == -100000){
                    matrix[i][j] = 0;

                }
            }
        }
    }

    /*
    (0,3) (0,0) (0,3)
     */
    public static void main(String[] args) {
//        int[][] matrix = {
//                {1,1,1},
//                {1,0,1},
//                {1,1,1}
//        };

//        int[][] matrix = {
//                {0,1,1,0},
//                {1,1,1,1},
//                {1,1,1,1}
//        };

        int[][] matrix = {
                {1},
                {0},
                {3}
        };
        Solution solution = new Solution();
        solution.setZeroes(matrix);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
