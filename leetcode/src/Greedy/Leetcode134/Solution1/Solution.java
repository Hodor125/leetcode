package Greedy.Leetcode134.Solution1;

/**
 * @author ：hodor007
 * @date ：Created in 2020/12/15
 * @description ：
 * @version: 1.0
 */
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int i = 0;
        while(i < len){
            //找合格的第一个节点，每个点都找一遍
            if(cost[i] > gas[i]){
                i++;
                continue;
            }

            //接下去绕一周，如果回到原点就是合格的
            int ct = 1;    //计数绕行一周
            int _gas = gas[i] - cost[i];
            while(ct <= len){
                int j = (i + ct) % len;
                _gas += gas[j];
                if(_gas < cost[j]){
                    break;
                }
                //返回原点则可以直接返回结果
                if(j == i){
                    return i;
                }
                _gas -= cost[j];
                ct++;
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