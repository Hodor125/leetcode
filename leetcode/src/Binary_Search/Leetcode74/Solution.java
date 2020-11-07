package Binary_Search.Leetcode74;

import java.util.Arrays;

/**
 * 先写出正常的寻找一个数的二分查找（如果这个数存在一定能找到），最后设置返回(找到的数==target)即可
 * @author ：hodor007
 * @date ：Created in 2020/11/3
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int rows = matrix.length;
        int columns = matrix[0].length;
        int total = rows * columns;
        int l = 0;    //左指针
        int r = total - 1;    //右指针
        while (l < r){
            int mid = l + (r - l) / 2;
            int[] posM = transform(mid + 1, columns);
            if(matrix[posM[0]][posM[1]] > target){
                r = mid - 1;
            } else if(matrix[posM[0]][posM[1]] < target){
                l = mid + 1;
            } else {
                l = mid;
                break;
            }
        }
        int[] posL = transform(l + 1, columns);
//        System.out.println("ans:" + matrix[posL[0]][posL[1]]);

        return matrix[posL[0]][posL[1]] == target;
    }

    /**
     * 将位置转为矩阵下标
     * @param pos
     * @param columns
     * @return
     */
    private int[] transform(int pos,int columns){
        int row = pos / columns;
        int column = pos % columns;
        if(column == 0){
            return new int[]{row - 1,columns - 1};
        } else {
            return new int[]{row,column - 1};
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[][] matrix = {
//                {1,2,3},
//                {5,6,7},
//                {9,10,11}
//        };

        int[][] matrix = {
                {1,2}
        };

        // 2 5 7
//        for (int i = 1; i < 10; i++) {
//            boolean ans = solution.searchMatrix(matrix, i);
//            System.out.println(ans);
//        }
        solution.searchMatrix(matrix,2);

//        for (int i = 1; i < 10; i++) {
//            int[] transform = solution.transform(i, 3);
//            System.out.println(Arrays.toString(transform));
//        }
    }
}
