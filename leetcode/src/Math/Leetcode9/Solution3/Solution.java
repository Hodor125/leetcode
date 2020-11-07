package Math.Leetcode9.Solution3;

public class Solution {
    public boolean isPalindrome(int x) {
        //特判，负数和0结尾的大于0的数显然不是回文数
        if(x < 0 || (x > 0 && x % 10 == 0))
            return  false;

        int reverNum = 0;
        //把末尾的数字反转过来，x < reverNum的时候还没有反转过一半
        while (x > reverNum){
            int end = x % 10;
            reverNum  =  reverNum * 10 + end;
            x = x / 10;
        }
        System.out.println("x:" + x);
        System.out.println("reverNum:" + reverNum);

        //数字长度为偶数和奇数的情况
        return x == reverNum || x == reverNum / 10;
    }

    public static void main(String[] args) {
        int num = 12321;
        Solution solution = new Solution();
        boolean ans = solution.isPalindrome(num);
        System.out.println(ans);
    }
}
