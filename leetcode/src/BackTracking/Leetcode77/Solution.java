package BackTracking.Leetcode77;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：hodor007
 * @date ：Created in 2020/11/4
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> curAns = new ArrayList<>();
        if(n == 0)
            return ans;
        dfs(n,k,0,ans,curAns);
        return ans;
    }

    /**
     * 深度优先搜索
     * @param n 搜索的空间
     * @param k 子序列的长度
     * @param idx 当前在搜索空间的位置
     * @param ans 所有的答案序列
     * @param curAns 当前的答案序列
     */
    private void dfs(int n,int k,int idx,List<List<Integer>> ans,List<Integer> curAns){
        //设置循环终止的条件，子序列的长度达到k了
        if(curAns.size() == k){
            ans.add(new ArrayList<>(curAns));
            return;
        }

        //进行遍历
        for (int i = idx; i <= n - k + curAns.size(); i++) {
            curAns.add(i + 1);
            dfs(n,k,i + 1,ans,curAns);
            //回溯回来
            curAns.remove(curAns.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> combine = solution.combine(1, 1);
        for (List<Integer> integers : combine) {
            System.out.println(integers);
        }
    }
}
