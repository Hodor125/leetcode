package Link;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/*
官方解法
    原地进行指针操作
 */
public class Leecode328 {
    public static ListNode328 oddEvenList(ListNode328 head) {
        if(head == null)
            return null;

        ListNode328 evenHead = head.next;
        ListNode328 odd = head;
        ListNode328 even = evenHead;

        while(even != null && even.next != null){
            odd.next= even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        ListNode328 l1 = new ListNode328(1);
        ListNode328 l2 = new ListNode328(2);
        ListNode328 l3 = new ListNode328(3);
        ListNode328 l4 = new ListNode328(4);
        ListNode328 l5 = new ListNode328(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode328 node = oddEvenList(l1);
        while(node != null){
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println("null");
    }
}

class ListNode328 {
    int val;
    ListNode328 next;
    ListNode328() {}
    ListNode328(int val) { this.val = val; }
    ListNode328(int val, ListNode328 next) { this.val = val; this.next = next; }
  }