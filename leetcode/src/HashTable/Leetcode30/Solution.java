package HashTable.Leetcode30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if(s == null || s.length() == 0)
            return ans;

        int len = words.length;//子串的长度
        int subLen = words[0].length();

        HashMap<String, Integer> allWords = new HashMap<>();
        for (String word : words) {
            Integer count = allWords.getOrDefault(word, 0);
            allWords.put(word,count + 1);
        }

        for (int i = 0; i <= s.length() - len * subLen; i++) {
            HashMap<String, Integer> subAns = new HashMap<>();
            int num = 0;//记录添加的子串的长度

            //尝试匹配子串
            while(num < len){
                String substring = s.substring(i + num * subLen, i + (num + 1) * subLen);
                if(allWords.containsKey(substring)){
                    //如果包含了子串的单词
                    Integer count = subAns.getOrDefault(substring, 0);
                    subAns.put(substring,count + 1);
                } else {
                    break;
                }

                //包含的单词数超过了子串的单词数
                if(subAns.get(substring) > allWords.get(substring)){
                    break;
                }
                num++;
            }

            if(num == len){
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        Solution solution = new Solution();
        List<Integer> ans = solution.findSubstring(str, words);
        for (Integer an : ans) {
            System.out.println(an);
        }
    }
}
