package Sort.Leecode242;

import java.util.Arrays;

/*
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

输入: s = "anagram", t = "nagaram"
输出: true

 */
public class Solution {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        boolean flag = isAnagram2(s, t);
        System.out.println(flag);
    }

    //方法一：排序
    public static boolean isAnagram(String s, String t) {
        //注意函数格式
        if(s.length() != t.length()){
            System.out.println("length");
            return false;
        }

        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();

        Arrays.sort(chars);
        Arrays.sort(chart);
        //注意函数格式
        return(Arrays.equals(chars,chart));
    }

    //方法二哈希表
    public static boolean isAnagram2(String s, String t){
        if(s.length() != t.length())
            return false;

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < count.length; i++) {
            if(count[i] != 0)
                return false;
        }
        return true;
    }
}
