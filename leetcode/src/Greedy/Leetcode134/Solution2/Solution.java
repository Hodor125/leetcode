package Greedy.Leetcode134.Solution2;

/**
 * 优化，记录每一个点能到达的最远节点和剩余的汽油
 * @author ：hodor007
 * @date ：Created in 2020/12/15
 * @description ：
 * @version: 1.0
 */
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int i = 0;
        int[] farIndex = new int[len];
        for (int j = 0; j < len; j++) {
            farIndex[j] = -1;
        }
        int[] farRemain = new int[len];
        while(i < len){
            //找合格的第一个节点，每个点都找一遍
            int j = i;
            int remain = 0;
            int ct = 1;
            while(ct <= len + 1){
                remain += gas[j];
                if(remain < cost[j]){
                    break;
                }
                if(ct > 1 && j == i){
                    return i;
                }
                remain -= cost[j];
                j = (j + 1) % len;
                if(farIndex[j] != -1){
                    remain = remain + farRemain[j];
                    j = farIndex[j];
                    remain -= gas[j];
                }
                ct++;
            }
            if(i != j){
                farIndex[i] = j;
                farRemain[i] = remain;
            }
            i++;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] gas = {5,8,2,8};
        int[] cost = {6,5,6,6};
        Solution solution = new Solution();
        int ans = solution.canCompleteCircuit(gas, cost);
        System.out.println(ans);
    }
}