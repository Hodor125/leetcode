package Array.Leecode509;

//递归
public class Solution2 {
    public static void main(String[] args) {
        int ans = new Solution2().fib(4);
        System.out.println(ans);
    }

    public int fib(int N) {
        if(N <= 1)
            return N;
        return count(N);
    }

    public int count(int num){
        if(num == 0)
            return 0;
        if(num == 1)
            return 1;
        return count(num - 1) + count(num - 2);
    }
}
