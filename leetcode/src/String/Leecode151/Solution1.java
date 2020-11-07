package String.Leecode151;

public class Solution1 {
    public static void main(String[] args) {
        String str = "the sky is blue";
        String s = new Solution1().reverseWords(str);
        System.out.println(s);
    }

    //StringBuffer效率更高
    public String reverseWords(String s) {
        if(s == null || s.length() == 0)
            return s;
        s = s.trim();
        String[] words = s.split("\\s+");
//        for (String word : words) {
//            System.out.println(word);
//        }
        StringBuffer sb = new StringBuffer();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if(i != 0)
                sb.append(" ");
        }
        return sb.toString();
    }
}
