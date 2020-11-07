package Sort.Leecode56.Solution1;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 3},
                {2, 4},
                {8, 10},
                {15, 18}
        };
        int[][]ans = merge(arr);
        for (int[] ints : ans) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1,o2) -> o1[0] - o2[0]);

        int[][] ans = new int[intervals.length][2];

//        System.out.println("source:" );
//        for (int[] an : ans) {
//            System.out.println(Arrays.toString(an));
//        }
        int index = -1;
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            //空或者新节点前端大于上一个节点的末端
            if (index == -1 || interval[0] > ans[index][1]) {
                ans[++index] = interval;
//                System.out.println("add:" + index + " " + Arrays.toString(interval));
            } else {
                ans[index][1] = ans[index][1] > interval[1] ? ans[index][1] : interval[1];
//                System.out.println("change:"+index+" "+Arrays.toString(ans[index]));
            }
        }

        return Arrays.copyOfRange(ans, 0, index + 1);
    }
}
