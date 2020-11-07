package Binary_Search.Leetcode33.Soltion1;

class Solution {
    public int search(int[] nums, int target) {
        if(nums == null)
            return -1;

        if(nums.length == 1){
            return nums[0] == target ? 0 : -1;
        }

        int len = nums.length;
        int l = 0;
        int r = len - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] == target)
                return mid;

            if(target >= nums[0] && nums[0] <= nums[mid]){
                if(nums[mid] >= target){
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if(target < nums[0] && nums[mid] < target){
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return l;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,8,9,0,1,2,3,4};
        Solution solution = new Solution();
        int ans = solution.search(nums,8);
        System.out.println(ans);
    }
}
