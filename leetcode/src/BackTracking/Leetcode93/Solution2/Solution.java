package BackTracking.Leetcode93.Solution2;

import java.util.ArrayList;
import java.util.List;

/**
 * 先写出不带剪枝的原始版本，再进行优化
 * 如何设置终止条件很重要，因为把终止条件结束层数设置在外层导致写不出来
 * @author ：hodor007
 * @date ：Created in 2020/11/16
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans  = new ArrayList<>();
        if(s.length() < 4 || s.length() > 12)
            return ans;
        StringBuilder sb = new StringBuilder();
        dfs(ans,0,0,s,sb);
        return ans;
    }

    /**
     *
     * @param ans 全部的单
     * @param idx 当前的索引
     * @param pos 当前的层数，4层返回
     * @param s 搜索空间
     * @param subAns 子答案
     */
    private void dfs(List<String> ans, int idx, int pos,String s,StringBuilder subAns){
        //字符串已经全部遍历了
        if(idx == s.length()){
            //当前时第四层
            if(pos == 4){
                StringBuilder _subAns = new StringBuilder(subAns);
                _subAns.deleteCharAt(_subAns.length() - 1);
                ans.add(_subAns.toString());
                return;
            }
        }

        //可以判断剩余的位数进行剪枝，超出或者少于都可以排除
        if(s.length() - idx > 3 * (4 - pos) || s.length() - idx < (4 - pos)){
            return;
        } else {
            //三条分支
            for (int j = 1; j < 4; j++) {
                int i = idx;
                StringBuilder sb = new StringBuilder();
                //当前的位数足够
                if(idx + j <= s.length()){
                    for (; i < s.length() && i < idx + j; i++) {
                        sb.append(s.charAt(i));
                    }
                    //判断数字是否合法，不合法就跳过本次循环
                    if(!judge(sb))
                        continue;

                    subAns.append(sb);
                    subAns.append('.');
                    dfs(ans,i,pos + 1,s,subAns);
                    //回溯回来
                    for (int k = 0; k < j + 1; k++) {
                        subAns.deleteCharAt(subAns.length() - 1);
                    }
                }
            }
        }
    }

    private boolean judge(StringBuilder sb){
        //对0开头的情况进行判断
        if(sb.length() > 1 && sb.charAt(0) == '0')
            return false;

        int num = Integer.parseInt(sb.toString());
        if(num > 255)
            return false;

        return true;
    }

    public static void main(String[] args) {
        String ipAddr = "25525511135";
//        String ipAddr = "0000";
        Solution solution = new Solution();
        List<String> strings = solution.restoreIpAddresses(ipAddr);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
