package Binary_Search.Leecode350;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] arr1 = {1,2,2,1};
        int[] arr2 = {2,2};
        int[] ans = intersect2(arr1, arr2);
        System.out.println(Arrays.toString(ans));
    }

    //简单记录法
    public static int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length)
            intersect(nums2, nums1);

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            int count = map.getOrDefault(num,0);
            map.put(num, ++count);
        }

        int[] ans = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if(count > 0){
                count--;
                map.put(num, count);
                ans[index++] = num;
            } else {
                map.remove(num);
            }
        }
//        System.out.println(index);
        return Arrays.copyOfRange(ans,0,index);
        //后索引大一
    }

    //排序
    public static int[] intersect2(int[] nums1, int[] nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int len1 = nums1.length;
        int len2 = nums2.length;
        int index = 0,index1 = 0,index2 = 0;
        int[] ans = new int[Math.min(len1, len2)];

        while(index1 < len1 && index2 < len2){
            if(nums1[index1] < nums2[index2]){
                index1++;
            } else if(nums1[index1] > nums2[index2]){
                index2++;
            } else if(nums1[index1] == nums2[index2]){
                ans[index++] = nums1[index1];
                index1++;
                index2++;
            }
        }
        return Arrays.copyOfRange(ans,0,index);
    }
}
