package Math.Leetcode468.Solution3;

import java.util.regex.Pattern;

/**
 * @author ：hodor007
 * @date ：Created in 2021/3/22
 * @description ：
 * @version: 1.0
 */
public class Solution {
    String chunkIPv4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
    Pattern patternIPv4 = Pattern.compile("^(" + chunkIPv4 + "\\.){3}" + chunkIPv4 + "$");

    String chunkIPv6 = "([0-9a-fA-F]{1,4})";
    Pattern patternIPv6 = Pattern.compile("^(" + chunkIPv6 + "\\:){7}" + chunkIPv6 + "$");

    public String validIPAddress(String IP) {
        if(IP.contains(".")) {
            return (patternIPv4.matcher(IP).matches()) ? "IPv4" : "Neither";
        } else if(IP.contains(":")) {
            return (patternIPv6.matcher(IP).matches()) ? "IPv6" : "Neither";
        }
        return "Neither";
    }

    public static void main(String[] args) {
        String ip = "2001:0db8:85a3:0:0:8A2E:0370:7334";
//        String ip = "255.3.2.111";
        Solution solution = new Solution();
        String s = solution.validIPAddress(ip);
        System.out.println(s);
    }
}
