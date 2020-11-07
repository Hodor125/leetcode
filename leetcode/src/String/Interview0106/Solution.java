package String.Interview0106;

public class Solution {
    public static void main(String[] args) {
        String ans = compressString("abcabsffffffffffffffffffffff");
        System.out.println(ans);
    }

    public static String compressString(String S) {
        //空串
        if(S.length() == 0)
            return S;

        char temp = S.charAt(0);
        int count = 0;
        int len = S.length();
        String ans = "";
        for (int i = 0; i < len; i++) {
            if(S.charAt(i) == temp)
                count++;
            else{
                ans += "" + temp + count;
                temp = S.charAt(i);
                count = 1;
            }
        }
        ans += "" + temp + count;
        return ans.length() > S.length() ? S : ans;
    }
}
