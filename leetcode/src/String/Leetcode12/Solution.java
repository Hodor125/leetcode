package String.Leetcode12;

public class Solution {
    public String intToRoman(int num) {
        //先获取个十百千
        int thousand = num / 1000;
        int hundred = (num - thousand * 1000) / 100;
        int ten = (num - thousand * 1000 - hundred * 100) / 10;
        int digit = num - thousand * 1000 - hundred * 100 - ten * 10;

        String ans = "";
        if(thousand > 0 && thousand < 4){
            for (int i = 0; i < thousand; i++) {
                ans += "M";
            }
        }

        if(hundred > 0 && hundred < 4){
            for (int i = 0; i < hundred; i++) {
                ans += "C";
            }
        } else if (hundred == 4){
            ans += "CD";
        } else if (hundred > 4 && hundred < 9){
            ans += "D";
            for (int i = 0; i < hundred - 5; i++) {
                ans += "C";
            }
        } else if(hundred == 9){
            ans += "CM";
        }

        if(ten > 0 && ten < 4){
            for (int i = 0; i < ten; i++) {
                ans += "X";
            }
        } else if (ten == 4){
            ans += "XL";
        } else if (ten > 4 && ten < 9){
            ans += "L";
            for (int i = 0; i < ten - 5; i++) {
                ans += "X";
            }
        } else if(ten == 9){
            ans += "XC";
        }

        if(digit > 0 && digit < 4){
            for (int i = 0; i < digit; i++) {
                ans += "I";
            }
        } else if (digit == 4){
            ans += "IV";
        } else if (digit > 4 && digit < 9){
            ans += "V";
            for (int i = 0; i < digit - 5; i++) {
                ans += "I";
            }
        } else if(digit == 9){
            ans += "IX";
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.intToRoman(2789);
        System.out.println(s);
    }
}
