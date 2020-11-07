package Array.Leetcode73.Solution1;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author ：hodor007
 * @date ：Created in 2020/11/2
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        HashSet<Integer> rowSet = new HashSet<>();
        HashSet<Integer> columnSet = new HashSet<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(matrix[i][j] == 0){
                    rowSet.add(i);
                    columnSet.add(j);
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            if(rowSet.contains(i)){
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < columns; i++) {
            if(columnSet.contains(i)){
                for (int j = 0; j < rows; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };
        Solution solution = new Solution();
        solution.setZeroes(matrix);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
