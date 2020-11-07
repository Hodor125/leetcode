package Sort.Leetcode57;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author ：hodor007
 * @date ：Created in 2020/10/30
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals == null || intervals.length == 0){
            int[][] ans = new int[1][];
            if(newInterval != null || newInterval.length > 0){
                ans[0] = newInterval;
            }
            return ans;
        }
        ArrayList<int[]> _ans = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if(i == 0){
                if(newInterval[1] < intervals[i][0]){
                    _ans.add(intervals[i]);
                }
            }

            //起始点小于目标数组的直接加入新数组
            if(intervals[i][1] < newInterval[0] || intervals[i][0] > newInterval[1]){
                _ans.add(intervals[i]);
            } else {
                //有重叠的进行合并操作
                if(_ans.size() == 0){
                    if(intervals[i][1] < newInterval[1]){
                        //新的数组后边界较大
                        _ans.add(new int[]{intervals[i][0],newInterval[1]});
                    } else {
                        //新的数组被包含了
                        _ans.add(intervals[i]);
                    }
                } else {
                    //运行到这个分支显然i是大于1的
                    if(intervals[i - 1][1] < newInterval[0]){
                        //第一个合并的数组
                        if(newInterval[1] > intervals[i][1]){
                            //新的数组后边界较大
                            _ans.add(new int[]{intervals[i][0], newInterval[1]});
                        } else {
                            //新的数组被包含了
                            _ans.add(intervals[i]);
                        }
                    } else if(intervals[i][1] > _ans.get(_ans.size() - 1)[1]){
                        //第二个及以后被合并的数组
                        _ans.get(_ans.size() - 1)[1] = intervals[i][1];
                    }
                }
            }
        }

        if(_ans.get(_ans.size() - 1)[1] < newInterval[1]){
            _ans.add(newInterval);
        }

        int[][] ans = new int[_ans.size()][2];
        for (int i = 0; i < _ans.size(); i++) {
            ans[i][0] = _ans.get(i)[0];
            ans[i][1] = _ans.get(i)[1];
        }
        return ans;
    }

    public static void main(String[] args) {
        int [][] intervals = {
                {1,5}
        };
        int[] newInterval = {6,8};
        Solution solution = new Solution();
        int[][] ans = solution.insert(intervals, newInterval);
        for (int[] an : ans) {
            System.out.println(Arrays.toString(an));
        }
    }
}
