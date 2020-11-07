package Binary_Search.Leetcode15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
先进行排序
i进行遍历数组,l= i + 1,r = i - 1
while(l < r)
nums[i] + nums[l] + nums[r] < 0是nums[l]小了
nums[i] + nums[l] + nums[r] > 0是nums[r]大了
 */
public class Solution {
    //去重是关键
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        //特判
        if(nums.length < 3){
            return ans;
        }

        Arrays.sort(nums);
        int l = 0;
        int r = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if(i > 0 && nums[i] == nums[i - 1])
                continue;
            l = i + 1;
            r = len - 1;
            while(l < r){
                //去重
                if(nums[i] + nums[l] + nums[r] == 0){
                    ArrayList<Integer> subList = new ArrayList<>();
                    subList.add(nums[i]);
                    subList.add(nums[l]);
                    subList.add(nums[r]);
                    ans.add(subList);
                    l++;
                    r--;
                    //去重
                    while(l > 0 && l < len && nums[l] == nums[l - 1])
                        l++;
                    while(r < len - 1 && r > 0 &&nums[r] == nums[r + 1])
                        r--;
                    //还要继续下去
                    continue;
                }else if(nums[i] + nums[l] + nums[r] < 0){
                    l++;
                }else if(nums[i] + nums[l] + nums[r] > 0){
                    r--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,0};
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.threeSum(arr);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
