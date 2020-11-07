package String.Leecode58;

import Array.Leecode509.Solution2;

public class Solution {
    public static void main(String[] args) {
        int len = new Solution().lengthOfLastWord("a ");
        System.out.println(len);
    }

    public int lengthOfLastWord(String s) {
        if("".equals(s))
            return 0;

        s = s.trim();
        int count = 0;
        for (int i = s.length() - 1; i >= 0 ; i--) {
            if(s.charAt(i) != ' '){
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
