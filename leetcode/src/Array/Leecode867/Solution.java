package Array.Leecode867;


import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] A = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] B = transpose(A);
        for (int i = 0; i < B.length; i++) {
            System.out.println(Arrays.toString(B[i]));
        }
    }

    public static int[][] transpose(int[][] A) {
        int len = A.length;
        int wid = A[0].length;

        int[][] B = new int[wid][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < wid; j++) {
                B[j][i] = A[i][j];
            }
        }
        return B;
    }
}
