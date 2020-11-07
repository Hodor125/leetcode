package String.Leecode14;

/**
 * 纵向遍历取得最长公共前缀
 */
public class Solution2 {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        String ans = new Solution1().longestCommonPrefix(strs);
        System.out.println(ans);
    }

    public String longestCommonPrefix(String[] strs){
        if(strs == null || strs.length == 0)
            return "";

        String prefix = strs[0];
        int pre_len = prefix.length();
        int len = strs.length;
        for (int i = 0; i < pre_len; i++) {
            char ch = prefix.charAt(i);
            for (int j = 1; j < len; j++) {
                if(i == strs[j].length() || strs[j].charAt(i) != ch)
                    return prefix.substring(0,i);
            }
        }
        return prefix;
    }

}
