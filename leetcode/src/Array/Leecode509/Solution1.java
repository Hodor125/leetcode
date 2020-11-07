package Array.Leecode509;

public class Solution1 {
    public static void main(String[] args) {
        int ans = new Solution1().fib(4);
        System.out.println(ans);
    }

    //记忆化自底向上的方法
    public int fib(int N) {
        if(N <= 1)
            return N;

        int[] arr = new int[N + 1];
        arr[1] = 1;
        for (int i = 2; i < N + 1; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[N];
    }
}
