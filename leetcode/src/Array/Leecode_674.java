package Array;

/*
动态进行比较
    ans存储最大连续长度
    count存储当前的连续序列
 */
public class Leecode_674 {
    public static void main(String[] args) {
        int[] nums = {2,2,2,2,2};
        System.out.println("length:" + Leecode_674.findLengthOfLCIS(nums));
    }

    public static int findLengthOfLCIS(int[] nums) {
        if(nums.length <= 1)
            return nums.length;
        int ans = 0,count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i + 1] > nums[i])
                count++;
            else
                count = 1;
            ans = ans > count ? ans : count;
        }
        return ans;
    }
}

