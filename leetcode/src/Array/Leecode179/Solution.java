package Array.Leecode179;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String largestNumber(int[] nums) {
        //思路：高位大的数放前面
        //问题：如何设计比较的函数，数字的位数不同如何比较，使用hashmap存储？智障。

        //官方题解，comparator重写

        //特判
        if(nums == null || nums.length == 0)
            return null;

        //转为字符串
        String[] nums_Str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums_Str[i] = Integer.toString(nums[i]);
        }

        //排序，使用重写的comparator
        Arrays.sort(nums_Str,new comparatorString());

        String ans = "";

        //最大的数为0则直接返回字符串0
        if(nums_Str[0].equals("0"))
            return "0";

        for (int i = 0; i < nums_Str.length; i++) {
            ans += nums_Str[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr ={3,30,34,5,9};

        Solution solution = new Solution();
        String s = solution.largestNumber(arr);
        System.out.println(s);
    }
}

class comparatorString implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        String str1 = o1 + o2;
        String str2 = o2 + o1;
        //前面的字符串比较小的话会返回负数，组合的字符串较小
        return str2.compareTo(str1);
    }
}