package Greedy.Leecode45.Solution1;

public class Solution {
    public static void main(String[] args) {
        int[] steps = {2,3,1,1,4};
        int jump = new Solution().jump(steps);
        System.out.println(jump);
    }

    //贪心算法，反向思考问题
    public int jump(int[] nums) {
        int position = nums.length - 1;
        int step = 0;
        while(position > 0){
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] + i >= position){
                    step++;
                    position = i;
                    break;
                }
            }
        }
        return step;
    }
}
