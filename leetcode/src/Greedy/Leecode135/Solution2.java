package Greedy.Leecode135;


import java.util.Arrays;

/*
使用贪心算法:每个数左右两边各自局部最优，取两者的较大值，获得的就是全局最优
 */

public class Solution2 {
    public static void main(String[] args) {
        int[] rating = {1,2,2};
        int candy = new Solution2().candy(rating);
        System.out.println(candy);
    }

    public int candy(int[] ratings) {
        int[] l2r = new int[ratings.length];
        int[] r2l = new int[ratings.length];
        int[] candy = new int[ratings.length];
        Arrays.fill(l2r,1);
        Arrays.fill(r2l,1);

        //左侧局部最优
        for (int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i - 1])
                l2r[i] = l2r[i - 1] + 1;
//            else if(ratings[i] == ratings[i - 1])
//                l2r[i] = l2r[i - 1];
        }

        //右侧局部最优
        for (int i = ratings.length - 2; i >=0 ; i--) {
            if(ratings[i] > ratings[i + 1])
                r2l[i] = r2l[i + 1] + 1;
//            else if(ratings[i] == ratings[i + 1])
//                r2l[i] = r2l[i + 1];
        }

        //取两者较大值
        int sum = 0;
        for (int i = 0; i < candy.length; i++) {
            candy[i] = Math.max(l2r[i],r2l[i]);
            sum += candy[i];
        }
        return sum;
    }
}
