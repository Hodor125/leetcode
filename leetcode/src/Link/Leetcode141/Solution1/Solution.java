package Link.Leetcode141.Solution1;

/**
 * 使用快慢指针判定
 * 所谓的Floydd判圈
 * @author ：hodor007
 * @date ：Created in 2020/12/9
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while(fast != slow){
            if(fast == null || fast.next == null){
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
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