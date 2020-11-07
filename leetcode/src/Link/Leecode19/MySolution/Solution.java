package Link.Leecode19.MySolution;

/**
 * 二刷
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return head;

        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode p = newHead;
        ListNode q = head;
        ListNode pre = newHead;

        for (int i = 0; i < n; i++) {
            p = p.next;
        }

        while(p.next != null){
            p = p.next;
            q = q.next;
            pre = pre.next;
        }

        pre.next = q.next;

        return newHead.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}