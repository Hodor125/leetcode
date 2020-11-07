package HashTable.Leecode349;

import java.util.HashSet;
import java.util.Iterator;

public class Solution {

    public static void main(String[] args) {
        int[] arr1 = {1,3,3,4,5,5,2};
        int[] arr2 = {6,3,8,4};
        int[] ans = new Solution().intersection(arr1,arr2);
        for (int an : ans) {
            System.out.print(an + " ");
        }
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> ans = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }

        for (int i : nums2) {
            if(set.contains(i)){
                ans.add(i);
//                System.out.println("add:" + i);
            }
        }

//        System.out.println("sixe:" + ans.size());
        int i = 0;
        int[] arr_ans = new int[ans.size()];
//        System.out.println("ans size:" + ans.size());
        Iterator<Integer> it = ans.iterator();
        while(it.hasNext()){
            arr_ans[i] = it.next().intValue();
//            System.out.println("add:" + arr_ans[i]);
            i++;
        }
        return arr_ans;
    }
}
