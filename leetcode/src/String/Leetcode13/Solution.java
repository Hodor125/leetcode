package String.Leetcode13;

public class Solution {
    public int romanToInt(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int len = s.length();
        char[] chars = s.toCharArray();
        int ans = 0;

        for (int i = 0; i < len; i++) {
            if(chars[i] == 'M')
                ans += 1000;
            else if(chars[i] == 'D')
                ans += 500;
            else if(chars[i] == 'C'){
                if(i + 1 < len && chars[i + 1] == 'D'){
                    ans += 400;
                    i++;
                }else if(i + 1 < len && chars[i + 1] == 'M'){
                    ans += 900;
                    i++;
                }else{
                    ans += 100;
                }
            }else if(chars[i] == 'L')
                ans += 50;
            else if(chars[i] == 'X'){
                if(i + 1 < len && chars[i + 1] == 'L'){
                    ans += 40;
                    i++;
                }else if(i + 1 < len && chars[i + 1] == 'C'){
                    ans +=90;
                    i++;
                }else{
                    ans += 10;
                }
            }else if(chars[i] == 'V')
                ans += 5;
            else if(chars[i] == 'I'){
                if(i + 1 < len && chars[i + 1] == 'V'){
                    ans += 4;
                    i++;
                }else if(i + 1 < len && chars[i + 1] == 'X'){
                    ans += 9;
                    i++;
                }else{
                    ans += 1;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String num = "IX";
        Solution solution = new Solution();
        int ans = solution.romanToInt(num);
        System.out.println(ans);
    }
}
