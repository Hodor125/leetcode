package Greedy.Leecode575;

import java.util.Arrays;
import java.util.HashSet;

/*
默认数组无序
 */
class Solution {
    public static void main(String[] args) {
        int[] candises = {1,1,1,1,2,2,2,3,3,3};
        int ans = new Solution().distributeCandies2(candises);
        System.out.println(ans);
    }

    //HashSet
    public int distributeCandies(int[] candies) {
        Arrays.sort(candies);
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < candies.length; i++) {
            set.add(candies[i]);
        }
        return Math.min(set.size(), candies.length / 2);
    }

    public int distributeCandies2(int[] candies){
        Arrays.sort(candies);
        int count = 1;
        for (int i = 1; i < candies.length && count < candies.length / 2; i++) {
            if(candies[i] > candies[i - 1])
                count++;
        }
        return Math.min(count,candies.length / 2);
    }
}