package String.Leecode14;

/**
 * 横向两两对比
 */
public class Solution1 {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        String ans = new Solution1().longestCommonPrefix(strs);
        System.out.println(ans);
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length ==0)
            return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = commonPrefix(prefix,strs[i]);
        }
        return prefix;
    }

    public String commonPrefix(String str1,String str2){
        int len = Math.min(str1.length(),str2.length());
        int i = 0;
        int index = 0;
        while(i < len){
            if(str1.charAt(i) == str2.charAt(i))
                index++;
            else
                break;
            i++;
        }
        return str1.substring(0,index);
    }
}
