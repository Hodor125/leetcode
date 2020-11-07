package dfs.Leetcode40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：hodor007
 * @date ：Created in 2020/10/26
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
                dfs(ans,combine,candidates,_sum,target,i + 1);
                combine.remove(combine.size() - 1);
            } else {
                //continue? break?
                //顺序数组可以使用break
                break;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = {10,1,2,7,6,1,5};
        List<List<Integer>> lists = solution.combinationSum(ints, 8);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
