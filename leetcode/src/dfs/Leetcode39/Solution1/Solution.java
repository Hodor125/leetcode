package dfs.Leetcode39.Solution1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：hodor007
 * @date ：Created in 2020/10/25
 * @description ：
 * @version: 1.0
 */

/**
 * 逆序
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        dfs(ans,combine,target,0,candidates);
        return ans;
    }

    /**
     *
     * @param ans 所有答案
     * @param combine 当前答案
     * @param target 剩余的数
     * @param idx 当前的遍历到的索引
     * @param candidates 候选数组
     */
    public void dfs(List<List<Integer>> ans,List<Integer> combine,int target,int idx,int[] candidates){
        //结束条件
        if(idx == candidates.length){
            return;
        }

        if(target == 0){
            //必须定义新ArrayList存储
            ans.add(new ArrayList<>(combine));
            return;
        }
        //跳过当前的数字（从后往前枚举）
        dfs(ans,combine,target,idx + 1,candidates);
        //试探当前的数字是否符合要求
        if(target - candidates[idx] >= 0){
            combine.add(candidates[idx]);
            dfs(ans,combine,target - candidates[idx],idx,candidates);
            //回溯回来，移除试探添加的数字
            combine.remove(combine.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.combinationSum(new int[]{2, 3, 6, 7}, 7);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}