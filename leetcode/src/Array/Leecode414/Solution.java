package Array.Leecode414;

import com.sun.xml.internal.ws.api.server.WSWebServiceContext;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {5,2,2};
        int i = new Solution().thirdMax(arr);
        System.out.println(i);
    }

    public int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;
//        System.out.println(first);

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > first) {
                count++;
                third = second;
                second = first;
                first = nums[i];
            }else if (nums[i] > second && nums[i] < first) {
                count++;
                third = second;
                second = nums[i];
            }else if (nums[i] > third && nums[i] < second){
                third = nums[i];
                count++;
            }
        }

        if (count < 3)
            return new Long(first).intValue();
        return new Long(third).intValue();
    }
}
