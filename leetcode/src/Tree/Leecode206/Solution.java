package Tree.Leecode206;

public class Solution {
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

        ListNode ans = new Solution().reverseList(l1);
        ListNode p = ans;
        while(p != null){
            System.out.print(p.val + " ");
            p = p.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if(head == null)
            return head;
        ListNode pre = null;
        ListNode p = head;
        ListNode q = head.next;

        while(q != null){
            p.next = pre;
            pre = p;
            p = q;
            q = q.next;
        }
        p.next = pre;

        return p;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}