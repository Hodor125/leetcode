package Greedy.Leecode605;

public class Solution {
    public static void main(String[] args) {
        int[] flowerbed = {1,0,0,0,0,1};
        Solution s = new Solution();
        boolean flag = s.canPlaceFlowers(flowerbed,2);
        System.out.println(flag);
    }
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) &&
                    (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                count++;
            }
        }
        return count >= n;
    }
}
