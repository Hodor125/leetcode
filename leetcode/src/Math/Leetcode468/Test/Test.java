package Math.Leetcode468.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 出现大小写各两个
 * @author ：hodor007
 * @date ：Created in 2021/3/22
 * @description ：
 * @version: 1.0
 */
//               /^(?=.*[a-z]{2,})(?=.*[A-Z])(2,)(?=.*/d+)[/s/S]{8,16}$/
public class Test {
    Set<String> set = new HashSet<>();
    String pattern = "\\.*[a-z]\\.*[a-z]\\.*[A-Z]\\.*[A-Z]\\.*\\d\\.*";

    public static void main(String[] args) {
        System.out.println(new Test().pattern);
    }
}
