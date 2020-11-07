package String.Leetcode28;

public class Solution {
    public int strStr(String haystack, String needle) {
        //特判，符合indexOf的定义
        if(needle.equals(""))
            return 0;
        if(haystack.equals(""))
            return -1;

        char[] hay = haystack.toCharArray();
        char[] nee = needle.toCharArray();

        int len_h = hay.length;
        int len_n = nee.length;
        int i = 0;//长串指针
        int j = 0;//短串指针

        //特判，haystack比needle短
        if(len_h < len_n)
            return -1;

        while (i < len_h){
            if(hay[i] == nee[j]){
                //匹配结束
                if(j == len_n - 1)
                    break;

                i++;
                j++;

                //特判，haystack结束了，needle还没结束
                if(i == len_h && j < len_n)
                    return -1;
            } else {
                //不匹配
                i = i - j + 1;
                j = 0;

                //特判，不匹配且haystack结束
                if(i == len_h)
                    return -1;
            }
        }

        if(j == len_n - 1)
            return i - j;
        else
            return  -1;
    }

    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "sippia";
        Solution solution = new Solution();
        int pos = solution.strStr(haystack, needle);
        System.out.println(pos);
    }
}
