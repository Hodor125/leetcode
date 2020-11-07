package String.Leecode125;

public class Solution1 {
    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        boolean flag = new Solution1().isPalindrome2(str);
        System.out.println(flag);
    }

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                sb.append(Character.toLowerCase(ch));
            }
        }
        StringBuilder sb2 = new StringBuilder(sb).reverse();
        return sb2.toString().equals(sb.toString());
    }

    public boolean isPalindrome2(String s){
        int l = 0;
        int r = s.length() - 1;
        while(l < r){
            while(l < r && !Character.isLetterOrDigit(s.charAt(l))){
                l++;
            }

            while(l < r && !Character.isLetterOrDigit(s.charAt(r))){
                r--;
            }

            if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
                return false;
            }
            else{
                l++;
                r--;
            }
        }
        return true;
    }
}
