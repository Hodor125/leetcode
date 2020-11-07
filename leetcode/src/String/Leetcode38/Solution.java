package String.Leetcode38;

public class Solution {
    public String countAndSay(int n) {
        if(n == 1)
            return "1";

        String str = countAndSay(n - 1);
        int len = str.length();
        int start = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (i == len - 1){
                sb.append(i - start + 1).append(str.charAt(i));
            } else if(str.charAt(i) != str.charAt(i + 1)){
                sb.append(i - start + 1).append(str.charAt(i));
                start = i + 1;
            }
        }
        //111221
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String ans = solution.countAndSay(5);
        System.out.println(ans);
    }
}
