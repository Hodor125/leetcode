package HashTable.Leecode128;

import java.util.HashSet;

public class Solution2 {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int i = new Solution2().longestConsecutive(nums);
        System.out.println(i);
    }

    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        //使用set存储不重复的数字集合用于下方判断数字是否存在于数组中
        HashSet<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }

        int res = 0;

        //事件复杂度为1，每个数字仅仅在内部循环中被访问一遍
        for (int i = 0; i < nums.length; i++) {
            //如果存在比当前数字小1的数字则跳过这个数，知道访问到没有比当前数字小1的数字
            if(set.contains(nums[i] - 1))
                continue;

            int t = nums[i];
            int count = 1;

            //计算当前连续序列的长度
            while(set.contains(t + 1)){
                count++;
                t = t + 1;
            }
            res = res > count ? res : count;
        }
        return res;
    }
}
