package Greedy.Leetcode670.Solution2;

/**
 * @author ：hodor007
 * @date ：Created in 2021/3/20
 * @description ：
 * @version: 1.0
 */
class Solution {
    public int maximumSwap(int num) {

        String s = String.valueOf(num);
        char[] chars = s.toCharArray();
        int[] indexs = new int[10];
        for (int i = 0; i < s.length(); i++) {
            indexs[chars[i] - '0'] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 9; j > chars[i] - '0'; j--) {
                if(indexs[j] > i) {
                    swap(chars, i, indexs[j]);
                    String s1 = new String(chars);
                    return Integer.parseInt(s1);
                }
            }
        }
        return Integer.parseInt(new String(chars));
    }

    private void swap(char[] chars, int i, int j) {
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }

    public static void main(String[] args) {
        int i = 12345;
        Solution solution = new Solution();
        int i1 = solution.maximumSwap(i);
        System.out.println(i1);
    }
}