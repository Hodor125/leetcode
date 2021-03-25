package Math.Leetcode468.Solution1;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author ：hodor007
 * @date ：Created in 2021/3/22
 * @description ：
 * @version: 1.0
 */
class Solution {
    public String validIPAddress(String IP) {
        try {
            return (InetAddress.getByName(IP) instanceof Inet6Address) ? "IPv6" : "IPv4";
        } catch (UnknownHostException e) {
            return "Neither";
        }
    }

    public static void main(String[] args) {
        String ip = "255.2.23.12";
        Solution solution = new Solution();
        String s = solution.validIPAddress(ip);
        System.out.println(s);
    }
}
