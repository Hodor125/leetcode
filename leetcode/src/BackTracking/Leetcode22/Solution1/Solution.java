package BackTracking.Leetcode22.Solution1;

import java.util.ArrayList;
import java.util.List;

/**
 * 深度优先搜索无需回溯，字符串特殊性？
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        dfs(list,"",n,n);
        return list;
    }

    public void dfs(List<String> ans,String subAns,int left,int rigth){
        if(left == 0 && rigth == 0){
            ans.add(subAns);
            return;
        }

        //剪枝
        if(left > rigth){
            return;
        }

        //并没有使用什么中间变量，回溯无需修改
        if(left > 0){
            dfs(ans,subAns + "(",left - 1,rigth);
        }

        if(rigth > 0){
            dfs(ans,subAns + ")",left,rigth - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> strings = solution.generateParenthesis(3);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
