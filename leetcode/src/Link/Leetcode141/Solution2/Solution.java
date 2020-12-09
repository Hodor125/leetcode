package Link.Leetcode141.Solution2;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 使用哈希表
 * @author ：hodor007
 * @date ：Created in 2020/12/9
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode p = head;
        while(p != null){
            if(!set.add(p)){
                return true;
            }
            p = p.next;
        }
        return false;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}