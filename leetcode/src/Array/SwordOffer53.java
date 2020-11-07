package Array;

/*
参考官方题解
使用二分查找
    设置左右指针ij，结束条件是i>j
    程序结束时i指向右边数组的首位，j指向左边数组的末位

考虑不存在的j = num - 1的情况：
    已经不相等了，之所以还要减一是因为可能有序号更小的存在
    假设之前不存在序号更小的存在，那么i最后肯定会增加到j + 1，不会错过答案
 */
public class SwordOffer53 {
    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4,5,6,7,9};
        System.out.println("result:" + SwordOffer53.missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while(i <= j){
            int num = (i + j) / 2;
            System.out.println("index:" + num + " num:" + nums[num]);
            if(nums[num] == num)
                i = num + 1;
            else
                j = num - 1;
            System.out.println("i:" + i + " j:" + j);
            System.out.println("---------------------");
        }

        return i;
    }
}
