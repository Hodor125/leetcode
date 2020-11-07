package Binary_Search.Leecode374;

public class Solution {
    private int ans = 4;

    public int guess(int num){
        if(num == ans)
            return 0;
        if(num > ans)
            return -1;
        return 1;
    }

    public int guessNumber(int n) {
        int l = 0;
        int r = n;
        int mid = 0;
        while(l <= r){
            mid = l + (r - l) / 2;
            if(guess(mid) == 0)
                return mid;
            else if(guess(mid) == 1){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        int i = new Solution().guessNumber(6);
        System.out.println(i);
    }
}
