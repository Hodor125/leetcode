package Greedy.SF14;

/**
 * @author ：hodor007
 * @date ：Created in 2021/3/28
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public int cuttingRope(int n) {
        int mod = (int) 1e9+7;
        if(n < 4)
            return n - 1;
        long res = 1;
        while(n > 4) {
            res = res * 3 % mod;
            n -= 3;
        }
        return (int) (res * n % mod);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.cuttingRope(10);
        System.out.println(i);
    }
}
