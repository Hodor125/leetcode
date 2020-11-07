package Binary_Search.Leetcode78;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：hodor007
 * @date ：Created in 2020/11/4
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curAns = new ArrayList<>();

        if(nums == null || nums.length ==0){
            return ans;
        }

        for (int i = 0; i < nums.length + 1; i++) {
            dfs(nums.length,nums, i,0,ans,curAns);
        }
        return ans;
    }

    /**
     * 深搜答案
     * @param n 解空间
     * @param k 当前搜索的子串的长度
     * @param idx 当前搜索的数再解空间的下标
     * @param ans 所有答案
     * @param curAns 当前子串
     */
    private void dfs(int n,int[] nums, int k,int idx, List<List<Integer>> ans,List<Integer> curAns){
        //循环停止条件
        if(curAns.size() == k){
            ans.add(new ArrayList<>(curAns));
            return;
        }

        //加入剪枝
        for (int i =  idx; i <= n - k + curAns.size(); i++) {
            curAns.add(nums[i]);
            dfs(n,nums,k,i + 1,ans,curAns);
            curAns.remove(curAns.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        Solution solution = new Solution();
        List<List<Integer>> subsets = solution.subsets(nums);
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
