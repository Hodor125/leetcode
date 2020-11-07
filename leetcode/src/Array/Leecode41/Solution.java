package Array.Leecode41;

public class Solution {
        public int firstMissingPositive(int[] nums) {
        //第一轮遍历判断1是否在数组中
        int len = nums.length;
        boolean oneExis = false;
        for (int i = 0; i < len; i++) {
            if(1 == nums[i]){
                oneExis = true;
                break;
            }
        }
        if(!oneExis)
            return 1;

        //如果1是存在的，那么1这个标志位就是能用的
        for (int i = 0; i < len; i++) {
            if(nums[i] <= 0)
                nums[i] = 1;
        }

        for (int i = 0; i < len; i++) {
            //考虑到正负的情况
            int pos = Math.abs(nums[i]) - 1;

            if(pos > len - 1)
                pos = 0;

            nums[pos] = -Math.abs(nums[pos]);
        }

        for (int i = 0; i < len; i++) {
            if(nums[i] > 0)
                return i + 1;
        }

        //1到len都存在则返回len + 1
        return len + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1,1000};
        Solution solution = new Solution();
        int ans = solution.firstMissingPositive(arr);
        System.out.println(ans);
    }
}
