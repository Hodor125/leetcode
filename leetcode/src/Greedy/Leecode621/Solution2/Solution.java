package Greedy.Leecode621.Solution2;

import java.util.*;

//实验品
public class Solution {
    public static void main(String[] args) {
        char[] arr = {'A','A','A','B','B','B','C','C','D','D','D','D'};
        int i = new Solution().leastInterval(arr,2);
//        System.out.println(i);

    }

    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c: tasks)
            map[c - 'A']++;
        PriorityQueue < Integer > queue = new PriorityQueue < > (26, Collections.reverseOrder());
        for (int f: map) {
//            if (f > 0)
                queue.add(f);
        }
        System.out.println(queue);
        int time = 0;
        while (!queue.isEmpty()) {
            int i = 0;
            List < Integer > temp = new ArrayList< >();
            while (i <= n) {
                if (!queue.isEmpty()) {
                    if (queue.peek() > 1)
                        temp.add(queue.poll() - 1);
                    else
                        queue.poll();
                }
                time++;

                //刹车
                if (queue.isEmpty() && temp.size() == 0)
                    break;
                i++;
            }
            for (int l: temp)
                queue.add(l);
        }
        return time;
    }
}
