package Link.Leecode82;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

public class Demo {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(4);
        ListNode l7 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = null;

        print(l1);

        ListNode ans = Demo.deleteDuplicates(l1);

        System.out.println("------------------------");
        print(ans);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return head;

        ListNode addHead = new ListNode(0);
        ListNode h = addHead;
        ListNode p = head;
        ListNode q = p.next;
        h.next = p;

        while(q != null){
            if(p.val == q.val){
                while(q.next != null && q.val == q.next.val)
                    q = q.next;
                h.next = q.next;
                p = h.next;
                if(p != null)
                    q = p.next;
                else
                    q = null;
            } else {
                h = h.next;
                p = p.next;
                q = q.next;
            }
        }
        return addHead.next;
    }

    public static void print(ListNode head){
        ListNode p = head;
        while(p != null){
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.println("null");
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}