package Greedy.Leecode45.Solution2;

class Solution {
    public static void main(String[] args) {
        int[] arr = {2,3,1,1,4};
        int jump = new Solution().jump(arr);
        System.out.println(jump);
    }

    //不会贪不会贪写的是真强
    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;

        //上一步到倒数第二个位置的话要继续运行
        //在可选择的范围中选出跳的最远的两步
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            //到达了第一步可选的范围就确定了第一步以及第二步的可选择范围？
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}

