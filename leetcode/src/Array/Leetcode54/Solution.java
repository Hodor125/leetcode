package Array.Leetcode54;

import java.util.ArrayList;
import java.util.List;

/**
 * 考虑遍历顺序
 * @author ：hodor007
 * @date ：Created in 2020/10/31
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if(matrix == null || matrix.length == 0){
            return list;
        }

        int rows = matrix.length;
        int columns = matrix[0].length;
        int count = 0;
        int total = rows * columns;
        int top = 0;
        int left = 0;
        int right = columns - 1;
        int bottom = rows - 1;
        while(count < total){
            for (int i = left; i <= right ; i++) {
                list.add(matrix[top][i]);
                count++;
            }
            for (int i = top + 1; i <= bottom; i++) {
                list.add(matrix[i][right]);
                count++;
            }
            if(top != bottom){
                for (int i = right - 1; i >= left + 1; i--) {
                    list.add(matrix[bottom][i]);
                    count++;
                }
            }
            if(left != right){
                for (int i = bottom; i >= top + 1; i--) {
                    list.add(matrix[i][left]);
                    count++;
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return list;
    }

    public static void main(String[] args) {
//        int[][] matrix = {
//                {1,2,3,4},
//                {5,6,7,8},
//                {9,10,11,12},
//                {13,14,15,16}
//        };

//        int [][] matrix = {
//                {1,2,3},
//                {4,5,6},
//                {7,8,9}
//        };

//        int[][] matrix = {
//                {1,2},
//                {3,4}
//        };

//        int[][] matrix = {
//                {1}
//        };

//        int[][] matrix = {
//                {1,2,3,4,5}
//        };

        int[][] matrix = {
                {1},
                {2},
                {3},
                {4},
                {5}
        };
        Solution solution = new Solution();
        List<Integer> ans = solution.spiralOrder(matrix);
        System.out.println(ans);
    }
}
