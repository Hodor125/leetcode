package Greedy.Leecode621.Solution3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Properties;

public class Solution {
    public static void main(String[] args) {
        char[] arr = {'A','A','A','B','B','B'};
        int i = new Solution().leastInterval(arr,2);
        System.out.println(i);
    }

    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char task : tasks) {
            map[task - 'A']++;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(26,new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i : map) {
            if(i > 0)
            queue.add(i);
        }

        int count = 0;
        while(!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                if(queue.peek() > 0){
                    int value = queue.peek();
                    list.add(value - 1);
                    System.out.println(value);
                    queue.poll();
                } else {
                    queue.poll();
                }
                count++;

                if(queue.isEmpty() && list.isEmpty())
                    break;

                for (Integer integer : list) {
                    queue.add(integer);
                }
            }
        }

        return 1;
    }
}
