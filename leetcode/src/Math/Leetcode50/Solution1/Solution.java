package Math.Leetcode50.Solution1;

/**
 * 幂为最大负数的时候会超出范围
 * @author ：hodor007
 * @date ：Created in 2020/10/29
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if(N > 0)
            return quickMul(x,N);
        else if (N < 0)
            return 1 / quickMul(x,-N);
        else
            return 1;
    }

    public double quickMul(double x,long n){
        if(n == 1){
            return x;
        }
        double y = quickMul(x,n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        double v = solution.myPow(1.00000,-2147483648);
        System.out.println(v);
    }
}
