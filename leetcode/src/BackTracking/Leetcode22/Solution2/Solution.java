package BackTracking.Leetcode22.Solution2;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用另一种终结条件，依旧是dfs
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if(n == 0)
            return ans;

        dfs(ans,"",0,0,n);
        return ans;
    }

    public void dfs(List<String> ans,String subAns,int left,int right,int n){
        //终止循环条件
        if(left == n && right == n){
            ans.add(subAns);
        }

        //剪枝
        if(left < right)
            return;

        //左分支
        if(left < n){
            dfs(ans,subAns + "(",left + 1,right,n);
        }

        //右分支
        if(right < n){
            dfs(ans,subAns + ")",left,right + 1,n);
        }
    }

    public static void main(String[] args) {
        int num = 3;
        Solution solution = new Solution();
        List<String> strings = solution.generateParenthesis(num);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
