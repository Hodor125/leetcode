package Greedy.Leetcode670.Solution1;

/**
 * @author ：hodor007
 * @date ：Created in 2021/3/20
 * @description ：
 * @version: 1.0
 */
class Solution {
    public int maximumSwap(int num) {
        String s = String.valueOf(num);
        int l = s.length();
        for (int i = 0; i < l - 1; i++) {
            for (int j = i + 1; j < l; j++) {
                String swap = swap(s, i, j);
                int res = Integer.parseInt(swap);
                num = Math.max(res, num);
            }
        }
        return num;
    }

    private String swap(String str, int i, int j) {
        char[] chars = str.toCharArray();
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
        return new String(chars);
    }

    public static void main(String[] args) {
        int num = 12345;
        Solution solution = new Solution();
        int i = solution.maximumSwap(num);
        System.out.println(i);
    }
}
