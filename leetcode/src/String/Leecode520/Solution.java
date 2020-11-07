package String.Leecode520;

public class Solution {
    public static void main(String[] args) {
        String str = "uSa";
        System.out.println(new Solution().detectCapitalUse(str));
    }

    public boolean detectCapitalUse(String word) {
        if(word == null)
            return true;
        if(word.charAt(0) >= 65 && word.charAt(0) <=90){
            if(word.length() >= 2){
                if(word.charAt(1) >= 65 && word.charAt(1) <=90){
                    //全大写
                    for (int i = 2; i < word.length(); i++) {
                        if(word.charAt(i) < 65 || word.charAt(i) > 90)
                            return false;
                    }
                }else{
                    //首字母大写，第二个字母小写
                    for (int i = 2; i < word.length(); i++) {
                        if(word.charAt(i) < 97 || word.charAt(i) > 122)
                            return false;
                    }
                }
            }
        }else{
            //全小写
            for (int i = 1; i < word.length(); i++) {
                if(word.charAt(i) < 97 || word.charAt(i) > 122)
                    return false;
            }
        }
        return true;
    }
}
