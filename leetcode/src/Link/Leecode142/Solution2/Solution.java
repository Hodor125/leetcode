package Link.Leecode142.Solution2;

import java.util.List;

/**
 * 可以证明快慢指针在入圈后第一圈就会相遇（看光放题解下面的证明）
 *
 * 设圈外长度a，圈长度b（看官方题解下面的题解）
 * 慢指针走了nb，到达入口处走的步数是a,a + b,...,a + nb
 * 所以将快指针挪到链表头，快慢指针同时动，相遇点就是入口
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null)
            return null;

        ListNode fast = head;
        ListNode slow = head;
        while(fast != null){
            if(fast.next != null)
                fast = fast.next.next;
            else
                return null;
            slow = slow.next;

            if(fast == slow)
                break;
        }

        if(fast == slow){
            fast = head;
            while(fast != slow){
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(-4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;

        Solution solution = new Solution();
        ListNode listNode = solution.detectCycle(l1);
        System.out.println(listNode.val);
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