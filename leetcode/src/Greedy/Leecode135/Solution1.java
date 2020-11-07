package Greedy.Leecode135;

import java.util.Arrays;

/*
暴力搜索提交超时
 */
public class Solution1 {
    public static void main(String[] args) {
        int[] arr = {1,2,2};
        int candy = new Solution1().candy(arr);
        System.out.println(candy);
    }

    public int candy(int[] ratings) {
        int[] arr = new int[ratings.length];
        Arrays.fill(arr,1);

        boolean flag = true;
        while(flag){
            flag = false;
            for (int i = 0; i < arr.length; i++) {
                if(i > 0 && ratings[i] > ratings[i - 1] && arr[i] <= arr[i - 1]){
                    flag = true;
                    arr[i] = arr[i - 1] + 1;
                }

                if(i < arr.length - 1 && ratings[i] > ratings[i + 1] && arr[i] <= arr[i + 1]){
                    arr[i] = arr[i + 1];
                    flag = true;
                }
            }
        }
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }
}
