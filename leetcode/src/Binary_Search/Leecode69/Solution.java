package Binary_Search.Leecode69;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int ans = solution.mySqrt(226);
        System.out.println(ans);
    }

    //问题：有些情况定位不到正确的答案，如8的平方根，使用额外变量存储可以解决
    public int mySqrt(int x) {
        int l = 0;
        int r = x;
        int mid = 0;
        int ans = 0;


        while(l <= r){
            mid = l + (r - l) / 2;
            //数字特别大的情况会超出范围，将临时数值转化为long
            if((long)mid * mid  > x)
                r = mid - 1;
            else{
                l = mid + 1;
                ans = mid;
            }
        }
        return ans;
    }
}
