package Link.SwordOffer22;

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
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
        l5.next = null;

        ListNode ans = getKthFromEnd2(l1,2);
        print(ans);
    }

    public static void print(ListNode head){
        ListNode p = head;
        while(p != null){
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.println("null");
    }

    public static ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode p = head;
        ListNode q = p;
        for (int i = 0; i < k - 1; i++) {
            q = q.next;
        }

        while(q.next != null){
            p = p.next;
            q = q.next;
        }
        return p;
    }

    //暴力解法
    public static ListNode getKthFromEnd(ListNode head, int k) {
        if(head == null)
            return head;

        ListNode p = head;
        int n = 0;
        while(p != null){
            p = p.next;
            n++;
        }
        int len = n - k;
        p = head;
        for (int i = 0; i < len; i++) {
            p = p.next;
        }
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