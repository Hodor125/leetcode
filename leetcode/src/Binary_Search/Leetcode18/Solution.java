package Binary_Search.Leetcode18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        //特判
        if(nums.length < 4)
            return ans;

        int len = nums.length;
        Arrays.sort(nums);//排序很重要，不排序就没用了
        for (int i = 0; i < len - 3; i++) {
            //剪枝
            //排过序了，最小的四个数都比目标大，没必要再找了
            if(i + 3 < len && nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target)
                break;
            //当前数和最大的三个数之和小于目标，可以跳过本次循环，没必要找了
            if(nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3] < target)
                continue;

            //去重
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }

            for (int j = i + 1; j < len - 2; j++) {
                //去重
                if(j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }

                //剪枝
                //确定的两个数和最小的两个数之和都大于目标，没必要找了
                if(j + 2 < len && nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target)
                    break;
                //确定的两个数和最大的两个数之和小于目标，本次循环没必要找了
                if(nums[i] + nums[j] + nums[len - 1] + nums[len - 2] < target)
                    continue;

                int l = j + 1;
                int r = len - 1;
                while(l < r){
                    if(nums[i] + nums[j] + nums[l] + nums[r] == target){
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        ans.add(list);
                        //得到一种正确答案之后进行去重
                        l++;
                        while(l > j && l < len && nums[l] == nums[l - 1])
                            l++;
                        r--;
                        while(r < len - 1 && r > j && nums[r] == nums[r + 1])
                            r--;
                    } else if(nums[i] + nums[j] + nums[l] + nums[r] > target){
                        r--;
                    } else if (nums[i] + nums[j] + nums[l] + nums[r] < target){
                        l++;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,0,-1,0,-2,2};
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.fourSum(arr,0);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
