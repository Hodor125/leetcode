package DP.Leecode338;

import java.util.Arrays;

/*
暴力遍历，对每个数字进行计算
 */
public class Solution1 {
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] ans = s.countBits(5);
        System.out.println(Arrays.toString(ans));

//        int i = s.countOnes(7);
//        System.out.println(i);
    }

    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 0; i < num + 1; i++) {
            ans[i] = countOnes(i);
        }
        return ans;
    }

    public int countOnes(int num){
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if((num & mask) != 0)
                count++;
            mask <<= 1;
        }
        return count;
    }
}
