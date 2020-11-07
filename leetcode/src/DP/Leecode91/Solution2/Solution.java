package DP.Leecode91.Solution2;

public class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0)
            return 0;

        int len = s.length();
        int[] arr = new int[len];

        //从字符串末尾向前迭代
        for (int i = len - 1; i >= 0; i--) {
            //本位是0这个长度就直接是0种方案
            if(s.charAt(i) == '0'){
                arr[len - 1 - i] = 0;
                continue;
            }

            //子串长度为1特判
            if(i == len - 1){
                arr[len - 1 - i] = 1;
                continue;
            }

            //长度为2特判
            if(i == len - 2){
                int ten = s.charAt(i) - '0';
                int digit = s.charAt(i + 1) - '0';
                int num = ten * 10 + digit;

                //应对10、20的情况
                if(num == 10 || num == 20){
                    arr[len - 1 - i] = 1;
                    continue;
                }

                if(num <=26 && i == len - 2){
                    arr[len - 1 - i] = 2;
                } else {
                    arr[len - 1 - i] = arr[len - 2 - i];
                }
                continue;
            }

            if(i < len - 1){
                int ten = s.charAt(i) - '0';
                int digit = s.charAt(i + 1) - '0';
                int num = ten * 10 + digit;

                //如果小于等于26,等于长度为i - 1和i - 2的和（前提长度大于2）
                if(num <= 26 && (len - 3 - i) >= 0){
                    arr[len - 1 - i] = arr[len - 2 - i] + arr[len - 3 - i];
                } else {
                    arr[len - 1 - i] = arr[len - 2 - i];
                }
            }

        }

        return arr[len - 1];
    }

    public static void main(String[] args) {
        String str = "230";

        Solution solution = new Solution();
        int ans = solution.numDecodings(str);
        System.out.println(ans);
    }
}
