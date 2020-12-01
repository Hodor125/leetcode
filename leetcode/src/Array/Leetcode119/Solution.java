package Array.Leetcode119;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：hodor007
 * @date ：Created in 2020/12/1
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public List<Integer> getRow(int numRows) {
        List<List<Integer>> total = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        List<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(1);
        total.add(l1);
        total.add(l2);

        for (int i = 3; i <= numRows + 1; i++) {
            //存放新的子答案
            ArrayList<Integer> subList = new ArrayList<>();
            //开头和结尾都是1
            subList.add(1);
            //获取上一行
            List<Integer> pre = total.get(i - 2);
            int size = pre.size();
            for (int j = 0; j < size; j++) {
                if(j + 1 < pre.size()){
                    int res = pre.get(j) + pre.get(j + 1);
                    subList.add(res);
                }
            }
            //添加1
            subList.add(1);
            total.add(subList);
        }
        return total.get(numRows);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> generate = solution.getRow(3);
        System.out.println(generate);
    }
}
