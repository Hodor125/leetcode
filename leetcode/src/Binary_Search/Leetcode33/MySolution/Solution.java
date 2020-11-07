package Binary_Search.Leetcode33.MySolution;

public class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        //特判
        if(target < nums[0] && target > nums[len - 1])
            return -1;

        if(nums.length == 1 && nums[l] != target)
            return -1;

        if(nums.length == 2){
            int num_l = Math.max(nums[0],nums[1]);
            int num_s = Math.min(nums[0],nums[1]);
            if(target < num_s || target > num_s && target < num_l || target > num_l)
                return -1;
        }

        int min = len - 1;
        while(min > 0 && nums[min] > nums[min - 1]){
            min--;
        }

        int max = 0;
        if(min > 0)
            max = min - 1;


        if(nums[r] == target){
            return r;
        }

        //目标大于第一个节点，右指针r左移
        if(nums[l] < target){
//            while(r > 0 && nums[r] > nums[r - 1]){
//                r--;
//            }
//
//            //小于最小的数
//            if(target < nums[r])
//                return -1;
//
//            if(r > 0)
//                r--;
            r = min;
        }

        if(nums[l] == target){
            return l;
        }

        //第一个节点大于目标，左指针l右移
        if(nums[l] > target){
//            while(l < len - 1 && nums[l] < nums[l + 1]){
//                l++;
//            }
//            //大于最大的数
//            if(target > nums[l])
//                return -1;
//            if(l < len - 1)
//                l++;
            l = min;
        }

        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] >= target){
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5};
        Solution solution = new Solution();
        int ans = solution.search(nums, 0);
        System.out.println(ans);
    }
}
