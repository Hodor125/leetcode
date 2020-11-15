package BackTracking.Leetcode90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 重复数字如何跳过，就是有重复的数字就去除
 * @author ：hodor007
 * @date ：Created in 2020/11/15
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subAns = new ArrayList<>();
        for (int i = 0; i < nums.length + 1; i++) {
            dfs(ans,subAns,0,i,0,nums);
        }
        return ans;
    }

    /**
     *
     * @param ans 答案
     * @param subAns 子答案
     * @param idx 下标
     * @param len 子答案的长度
     * @param curLen 当前的长度
     */
    private void dfs(List<List<Integer>> ans, List<Integer> subAns, int idx, int len, int curLen,int[] nums) {
        //循环终止条件
        if(len == curLen){
            ans.add(new ArrayList<>(subAns));
            return;
        }

        //加入剪枝
        for (int i = idx; i <= nums.length - len + curLen; i++) {
            if(i > idx && nums[i] == nums[i - 1])
                continue;
            subAns.add(nums[i]);
            dfs(ans,subAns,i + 1,len,curLen + 1,nums);
            subAns.remove(subAns.size() - 1);
        }
    }

    /*
    nums.length = 5
    len = 3;
    curLen = 0,
    idx = 3

    nums.length - (len - curLen)
     */

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,3,4,5};
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.subsetsWithDup(nums);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
        System.out.println("length:" + lists.size());
    }
}
