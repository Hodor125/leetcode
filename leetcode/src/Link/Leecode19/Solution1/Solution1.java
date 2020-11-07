package Link.Leecode19.Solution1;

public class Solution1 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = null;

        ListNode ans = new Solution1().removeNthFromEnd(l1,2);
        ListNode p = ans;
        while(p != null){
            System.out.print(p.val + " ");
            p = p.next;
        }

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return head;

        ListNode newHead = new ListNode(-1);
        newHead.next = head;

        ListNode q = newHead;
        ListNode p = head;
        ListNode pre = newHead;
        for (int i = 0; i < n; i++) {
            q = q.next;
        }

        while(q.next!= null){
            p = p.next;
            q = q.next;
            pre = pre.next;
        }

        pre.next = p.next;
        return newHead.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}