package DP.Leecode338;

import java.util.Arrays;

//动态规划，找出递推的规律

public class Solution2 {
    public static void main(String[] args) {
        int[] ans = new Solution2().countBits(5);
        System.out.println(Arrays.toString(ans));
    }

    public int[] countBits(int num) {
        int[] arr = new int[num + 1];
        int b = 1;
        int i = 0;

        //达成条件说明arr[num]已经被计算了
        while(b <= num){
            //内循环下标大b的位置1的数量增加一个
            while(i < b && i + b <= num){
                arr[i + b] = arr[i] + 1;
                i++;
            }
            b <<= 1;//b翻倍
            i = 0;//重置i
        }
        return arr;
    }
}
