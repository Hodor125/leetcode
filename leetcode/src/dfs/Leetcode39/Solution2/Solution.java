package dfs.Leetcode39.Solution2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：hodor007
 * @date ：Created in 2020/10/25
 * @description ：
 * @version: 1.0
 */

/**
 * 正序，注意题目条件，没有重复数字
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //排序成有序数组方便剪枝
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        dfs(ans,combine,candidates,0,target,0);
        return ans;
    }

    public void dfs(List<List<Integer>> ans, List<Integer> combine, int[] candidates,
                    int sum, int target, int idx){
        //递归终止条件
        if(sum == target){
            ans.add(new ArrayList<Integer>(combine));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            int _sum = sum + candidates[i];
            if(_sum <= target){
                combine.add(candidates[i]);
                dfs(ans,combine,candidates,_sum,target,i);
                combine.remove(combine.size() - 1);
            } else {
                //顺序数组可以使用break
                break;
            }
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
