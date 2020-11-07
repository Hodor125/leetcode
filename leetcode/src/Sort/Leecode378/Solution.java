package Sort.Leecode378;

/*
给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素
 */

class Solution {
    public static void main(String[] args) {
        int[][] m = {
                {1,5,9},
                {10,11,13},
                {12,13,15}
        };

        int num = kthSmallest(m,5);
        System.out.println(num);
    }

    public static int kthSmallest(int[][] matrix, int k) {
        int len = matrix.length;

        int left = matrix[0][0];
        int right = matrix[len  -1][len - 1];

        while(right > left){
            int mid = left+(right - left)/2;
            if(checkLess(matrix,mid,k)){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static boolean checkLess(int[][] matrix, int mid,int k){
        int num = 0;
        int j = 0;
        int i = matrix.length - 1;

        while(i>=0 && j< matrix.length){
            if(matrix[i][j] <= mid){
                j = j + 1;
                num += (i+1);
            } else{
                i--;
            }
            if(num >= k)
                return false;
        }
        return true;
    }
}
