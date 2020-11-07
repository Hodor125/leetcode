package Math.Leecode191;

import Array.Leecode509.Solution2;

public class Solution {
    public static void main(String[] args) {
        int i = new Solution().hammingWeight(4);
        System.out.println(i);
    }
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }
}
