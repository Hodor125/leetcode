package Link.Leecode203;

public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(6);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(5);
        ListNode l7 = new ListNode(6);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = null;

        ListNode ans = new Solution().removeElements(l1,6);

//        System.out.println(ans);
        ListNode p = ans;
        while(p != null){
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.println("null");
    }

    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return head;

        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode p = head;
        ListNode q = newHead;
        while(p != null){
//            System.out.println(p.val);
            if(p.val == val){
                q.next = p.next;
                p = p.next;
            }else{
                q = q.next;
                p = p.next;
            }
        }
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
