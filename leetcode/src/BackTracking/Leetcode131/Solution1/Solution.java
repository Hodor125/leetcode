package BackTracking.Leetcode131.Solution1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 回溯算法，效率极低
 * @author ：hodor007
 * @date ：Created in 2020/12/19
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        ArrayDeque<String> stack = new ArrayDeque<>();
        if(s == null || s.length() == 0){
            return res;
        }
        backtracking(s, 0, stack, res);
        return res;
    }

    public void backtracking(String str, int start, ArrayDeque<String> subAns, List<List<String>> res){
        if(start == str.length()){
            res.add(new ArrayList<>(subAns));
            return;
        }

        for (int i = start; i < str.length(); i++) {
            if(checkPalindrome(str, start, i)){
                subAns.addLast(str.substring(start,i + 1));
                backtracking(str, i + 1, subAns, res);
                //回溯回来
                subAns.pollLast();
            }
        }
    }

    private boolean checkPalindrome(String str, int start, int end){
        while(start < end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "aab";
        Solution solution = new Solution();
        List<List<String>> partition = solution.partition(str);
        for (List<String> strings : partition) {
            System.out.println(strings);
        }
    }
}
