package Math.Leetcode29;

public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 1)
            return dividend;
        if(divisor == -1){
            if (dividend == Integer.MIN_VALUE)
                return Integer.MAX_VALUE;
            else
                return -dividend;
        }

        //两数都小于0
        if(dividend < 0 && divisor < 0){
            return divide(Math.abs((long) dividend),Math.abs((long) divisor));
        } else if(dividend < 0 || divisor < 0){
            return -divide(Math.abs((long) dividend),Math.abs((long) divisor));
        } else {
            return divide((long)dividend,(long)divisor);
        }
    }

    public int divide(long dividend,long divisor){
        if(dividend < divisor)
            return 0;

        if(dividend == divisor)
            return 1;

        long sum = divisor;//多个除数相加的和
        int count = 1;
        while(dividend > sum){
            sum <<= 1;
            count <<= 1;
        }

        //循环终止的时候已经超过了，需要右移一位
        sum >>>= 1;
        count >>>= 1;

        return count + divide(dividend - sum,divisor);
    }

    public static void main(String[] args) {
        int dividend = 3;
        int divisor = 3;
        Solution solution = new Solution();
        int ans = solution.divide(dividend, divisor);
        System.out.println(ans);
    }
}
