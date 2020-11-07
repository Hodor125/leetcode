package Math.Leetcode7;

public class Solution {
    public int reverse(int x) {
        int reverNum = 0;

        while(x != 0){
            //最后一位
            int end = x % 10;

            //溢出则返回0
            if(reverNum > Integer.MAX_VALUE / 10 || reverNum < Integer.MIN_VALUE / 10)
                return 0;
            else if(reverNum == Integer.MAX_VALUE / 10 && end > 7
                    || reverNum == Integer.MIN_VALUE / 10 && end < -8)
                return 0;

            reverNum = reverNum * 10 + end;
            x = x / 10;
        }

        return reverNum;
    }

    public static void main(String[] args) {
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MAX_VALUE / 10);
//        System.out.println(Integer.MIN_VALUE);
//        System.out.println(Integer.MIN_VALUE / 10);

        Solution solution = new Solution();
        int reverse = solution.reverse(-2147483648);
        System.out.println(reverse);
    }
}
