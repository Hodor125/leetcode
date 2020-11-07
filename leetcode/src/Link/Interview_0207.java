package Link;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Interview_0207 {
    public static void main(String[] args) {
        ListNode0207 p = new ListNode0207(4);
        p.next = new ListNode0207(1);
        p.next.next = new ListNode0207(8);

        ListNode0207 q = new ListNode0207(5);
        q.next = new ListNode0207(0);
        q.next.next = new ListNode0207(1);
        q.next.next.next = new ListNode0207(8);

        ListNode0207 node = new ListNode0207(4);
        node.next = new ListNode0207(5);

        p.next.next.next = node;
        q.next.next.next.next = node;

        System.out.println("交点：" + Interview_0207.getIntersectionNode(p,q).val);
    }

    public static ListNode0207 getIntersectionNode(ListNode0207 headA, ListNode0207 headB) {
        ListNode0207 p = headA;
        ListNode0207 q = headB;

        while(p != q){
            p = p == null ? headA : p.next;
            q = q == null ? headB : q.next;
        }

        return p;
    }
}

 class ListNode0207 {
    int val;
    ListNode0207 next;
    ListNode0207(int x) {
        val = x;
        next = null;
    }
  }
