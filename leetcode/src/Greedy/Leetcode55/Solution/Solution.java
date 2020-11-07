package Greedy.Leetcode55.Solution;

public class Solution {
    public boolean canJump(int[] nums) {
        //只有一个节点显然是可以到达的
        if(nums.length == 1)
            return true;

        int maxpo = 0;
        int end = 0;
        int pre_maxpo = 0;//前一个最远的节点

        for (int i = 0; i < nums.length; i++) {
            //可以到达
            if(i + nums[i] >= nums.length - 1)
                return true;

            //更新最远能到达的点
            maxpo = Math.max(i + nums[i], maxpo);
            if(end == i){
                end = maxpo;
                //前一个最远的节点和现在最远的节点相同，这个情况就是停下来了，到不了最远的节点
                if(pre_maxpo == maxpo)
                    return false;
                pre_maxpo = maxpo;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] steps = {2,0,0};
        Solution solution = new Solution();
        boolean b = solution.canJump(steps);
        System.out.println(b);
    }
}
