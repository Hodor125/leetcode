package Greedy.Leecode621.Solution1;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        char[] arr = {'A','A','A','B','B','B'};
        int i = new Solution().leastInterval(arr, 2);
        System.out.println(i);
    }

    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            map[tasks[i] - 'A']++;
        }
        Arrays.sort(map);
        int count = 0;
        while(map[25] > 0){
            for (int i = 0; i < n + 1; i++) {
                if(map[25] == 0)
                    break;
                if(map[25 - i] > 0){
                    map[25 - i]--;
//                    count++;
                }
                count++;
            }
            Arrays.sort(map);
        }
        return count;
    }
}
