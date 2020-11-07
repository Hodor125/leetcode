package Link.Leecode61;

import java.util.LinkedList;

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

        ListNode res = rotateRight(l1,2);
        print(res);
    }

    public static void print(ListNode head){
        ListNode p = head;
        while(p != null){
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.println("null");
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null)
            return head;
        ListNode p = head;
        ListNode end = null;
        ListNode res;
        int length = 0;
        while(p != null){
            length++;
            if(p.next == null)
                end = p;
            p = p.next;
        }
        //如果移动为长度的整数倍则直接返回

        int num = k % length;
        if(num == 0)
            return head;

        int mov = length - num;

        p = head;
        for (int i = 0; i < mov - 1; i++) {
            p = p.next;
        }
        res = p.next;
        p.next = null;
        end.next = head;
        return res;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
