package dfs.Leecode397;

import Greedy.Leecode135.Solution2;

public class Solution {
    public static void main(String[] args) {
        int i = new Solution().integerReplacement(7);
        System.out.println(i);
    }

    public int integerReplacement(int n) {
        if(n == 1)
            return 0;
        //注意计算符号的优先级
//        Integer.MAX_VALUE超出栈内存
        if(n == Integer.MAX_VALUE)
            return 32;

        if((n&1) == 0){
            return 1 + integerReplacement(n / 2);
        }else{
            return 1 + Math.min(integerReplacement(n + 1),integerReplacement(n - 1));
        }
    }
}
