package Sort.Leecode56.Solution2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 二刷
 * @author ：hodor007
 * @date ：Created in 2020/10/30
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0){
            return intervals;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int[] interval : intervals) {
            System.out.println(Arrays.toString(interval));
        }
        System.out.println("----------------");

        ArrayList<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);
        for (int[] interval : intervals) {
            if(interval[0] <= ans.get(ans.size() - 1)[1]){
                if(interval[1] > ans.get(ans.size() - 1)[1])
                    ans.get(ans.size() - 1)[1] = interval[1];
            } else {
                ans.add(interval);
            }
        }

        int[][] _ans = new int[ans.size()][2];
        for (int i = 0; i < _ans.length; i++) {
            _ans[i][0] = ans.get(i)[0];
            _ans[i][1] = ans.get(i)[1];
        }
        return _ans;
    }

    public static void main(String[] args) {
        int[][] intervals = {
                {1,4},
                {2,3},
        };
        Solution solution = new Solution();
        int[][] merge = solution.merge(intervals);
        for (int[] ints : merge) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
