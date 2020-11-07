package String.Leeocode557;

public class Solution {
    public static void main(String[] args) {
        String str = "Let's take leecode contest";
        System.out.println(reverseWords(str));
    }

    //直接遍历，使用新的字符串存储
    public static String reverseWords(String s) {
        int i = 0;
        StringBuffer sb = new StringBuffer();

        System.out.println("length:" + s.length());
        while (i < s.length()) {
            int start = i;

//            System.out.println("i:" + i);

            while(i < s.length() && s.charAt(i) != ' ')
                i++;

//            System.out.println("i:" + i);

            for (int j = i-1; j >= start ; j--) {
                sb.append(s.charAt(j));
            }

            if(i < s.length() && s.charAt(i) == ' '){
                sb.append(' ');
                i++;
            }
        }
        String ans = sb.toString();
//        System.out.println("ans:" + ans);
        return ans;
    }
}
