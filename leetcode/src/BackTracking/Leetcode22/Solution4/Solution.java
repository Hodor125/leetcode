package BackTracking.Leetcode22.Solution4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 动态规划yes
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> ans0 = new ArrayList<>();
        ans0.add("");
        ans.add(ans0);

        List<String> ans1 = new ArrayList<>();
        ans1.add("()");
        ans.add(ans1);

        for (int i = 2; i <= n; i++) {
            List<String> temp = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                int t = i - j - 1;
                List<String> list1 = ans.get(j);
                List<String> list2 = ans.get(t);
                for (String s1 : list1) {
                    for (String s2 : list2) {
                        temp.add("(" + s1 + ")" + s2);
                    }
                }
            }
            ans.add(temp);
        }
        return ans.get(n);
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
