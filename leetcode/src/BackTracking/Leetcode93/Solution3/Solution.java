package BackTracking.Leetcode93.Solution3;

import java.util.ArrayList;
import java.util.List;

/**
 * 二刷
 * @author ：hodor007
 * @date ：Created in 2021/3/22
 * @description ：
 * @version: 1.0
 */
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if(s == null || s.length() == 0)
            return ans;
        if(s.length() < 4 || s.length() > 12)
            return ans;
        StringBuilder sb = new StringBuilder();
        backTracking(ans, 0, 0, s, sb);
        return ans;
    }

    /**
     *
     * @param ans
     * @param pos 当前层数
     * @param idx
     * @param s
     * @param subAns
     */
    private void backTracking(List<String> ans, int pos, int idx, String s, StringBuilder subAns) {
        //结束递归的条件
        if(pos == 4) {
            if(idx == s.length()){
                StringBuilder _subAns = new StringBuilder(subAns);
                _subAns.deleteCharAt(_subAns.length() - 1);
                ans.add(_subAns.toString());
            }
            return;
        }

        if(idx + 4 - pos > s.length() || idx + 4 * (4 - pos) - 1 < s.length())
            return;

        //三条分支
        for (int i = 1; i < 4; i++) {
            StringBuilder sb = new StringBuilder();
            int j = idx;
            for (; idx + i <= s.length() && j < idx + i; j++) {
                sb.append(s.charAt(j));
            }
            if(!judge(sb))
                continue;
            sb.append('.');
            subAns.append(sb);
            backTracking(ans, pos + 1, j, s, subAns);
            //回溯回来
            for (int k = 0; k < i + 1; k++) {
                subAns.deleteCharAt(subAns.length() - 1);
            }
        }
    }

    /**
     * 判断数字是否合法
     * @param sb
     * @return
     */
    private boolean judge(StringBuilder sb) {
        if(sb.length() == 0)
            return false;
        if (sb.length() != 1 && sb.charAt(0) == '0')
            return false;
        int num = Integer.parseInt(sb.toString());
        if(num > 255)
            return false;
        return true;
    }

    public static void main(String[] args) {
//        String str = "0000";
        String str = "25525511135";
        Solution solution = new Solution();
        List<String> strings = solution.restoreIpAddresses(str);
        System.out.println(strings);
    }
}
