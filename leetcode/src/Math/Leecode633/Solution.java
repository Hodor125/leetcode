package Math.Leecode633;

public class Solution {
    public static void main(String[] args) {
        int num = 1000000000;
        System.out.println(new Solution().judgeSquareSum2(num));
    }

    //数学方法
    public boolean judgeSquareSum(int c) {
        for (long i = 0; i * i <= c; i++) {
            int num1 = (int)(c - i * i);
            double num2 = Math.sqrt(num1);
            if(num2 == (int) num2)
                return true;
        }
        return false;
    }

    //二分查找
    public boolean judgeSquareSum2(int c){
        for (long i = 0; i * i <= c; i++) {
            long num1 = c - i * i;
            if(binarySearch((int)num1,0,num1))
                return true;
        }
        return false;
    }

    //使用int遇到大数会溢出
    public boolean binarySearch(int num,long l,long r){
        if(l > r)
            return false;
        long mid = l + (r - l) / 2;
        if(mid * mid == num)
            return true;
        if(mid * mid > num)
            return binarySearch(num,l,mid - 1);
        return binarySearch(num,mid+1,r);
    }

}
