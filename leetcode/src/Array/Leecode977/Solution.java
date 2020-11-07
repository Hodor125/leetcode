package Array.Leecode977;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {-3,-1,0};
        int[] ans = sortedSquares2(arr);
        System.out.println(Arrays.toString(ans));
    }

    //sort内置的快排算法
    public static int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }

    //双指针
    public static int[] sortedSquares2(int[] A) {
        int N = A.length;
        int b = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] >= 0) {
                b = i - 1;
                break;
            }
        }

        int[] ans = new int[N];
        int t = 0;
        int p = b + 1;
        System.out.println("b:" + A[b]);
//        System.out.println("in" + A[b]);
        while (b >= 0 && p < N) {
            if (A[b] * A[b] < A[p] * A[p]) {
                System.out.println("add" + A[b] * A[b]);
                ans[t++] = A[b] * A[b];
                b--;
            } else {
                ans[t++] = A[p] * A[p];
                System.out.println("add" + A[p] * A[p]);
                p++;
            }
        }

        while (b >= 0) {
            ans[t++] = A[b] * A[b];
            b--;
        }

        while (p < N) {
            ans[t++] = A[p] * A[p];
            p++;
        }
        return ans;
    }
}
