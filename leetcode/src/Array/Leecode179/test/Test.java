package Array.Leecode179.test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 测试使用的各种工具类
 */
public class Test {
    public static void main(String[] args) {
        //测试compareTo，请查看源码
        String num1 = "340";
        String num2 = "5";
        String[] nums = {"340","5"};
        int i = num1.compareTo(num2);
        System.out.println(i);

        //测试comparator接口
        comparatorDemo compareString = new comparatorDemo();
        int compare = compareString.compare(num1, num2);
        String comb;
        if(compare > 0)
            comb = num1 + num2;
        else
            comb = num2 + num1;
        System.out.println(comb);


        Arrays.sort(nums,new comparatorDemo());
        for (int j = 0; j < nums.length; j++) {
            System.out.println(nums[j]);
        }
    }
}

class comparatorDemo implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        String str1 = o1 + o2;
        String str2 = o2 + o1;
        //前面的字符串比较小的话会返回负数，组合的字符串较小
        return str2.compareTo(str1);
    }
}