package Math.Leetcode50.Solution2;

/**
 * 联系计算机组成原理，不难
 * @author ：hodor007
 * @date ：Created in 2020/10/29
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if(N < 0){
            return 1 / countPow(x,-N);
        } else if(N > 0){
            return countPow(x,N);
        } else {
            return 1;
        }
    }

    public double countPow(double x,long n){
        double sum = 1;
        double x_contribute = x;
        while(n > 0){
            if(n % 2 == 1){
                sum *= x_contribute;
            }
            x_contribute = x_contribute * x_contribute;
            n = n / 2;
        }
        return sum;
    }

    public static void main(String[] args) {
        double base = 2.0;
        int exp = -3;
        Solution solution = new Solution();
        double ans = solution.myPow(base, exp);
        System.out.println(ans);
    }
}
