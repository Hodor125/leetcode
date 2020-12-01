package DP.Leetcode120;

import java.util.List;

/**
 * @author ：hodor007
 * @date ：Created in 2020/12/1
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        for (int i = 0; i < len; i++) {
            if(i == 0){
                continue;
            }
            if(i == 1){
                List<Integer> lists = triangle.get(1);
                lists.set(0,lists.get(0) + triangle.get(0).get(0));
                lists.set(1,lists.get(1) + triangle.get(0).get(0));
                continue;
            }
            //上一行
            List<Integer> pre = triangle.get(i - 1);
            //本行
            List<Integer> cur = triangle.get(i);
            int curLen = cur.size();
            //修改
            for (int j = 0; j < curLen; j++) {
                //第一个
                if(j == 0){
                    cur.set(j, pre.get(j) + cur.get(j));
                    continue;
                }
                //最后一个
                if(j == curLen - 1){
                    cur.set(j, pre.get(j - 1) + cur.get(j));
                    continue;
                }
                int val1 = cur.get(j) + pre.get(j);
                int val2 = cur.get(j) + pre.get(j - 1);
                cur.set(j, Math.min(val1, val2));
            }
        }

        int minVal = Integer.MAX_VALUE;
        List<Integer> lastRow = triangle.get(len - 1);
        for (Integer val : lastRow) {
            minVal = Math.min(minVal, val);
        }
        return minVal;
    }
}
