package Link.Leecode24;

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

/*
使用递归返回，实际上每次返回的是第二个节点
 */
public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
//        ListNode l5 = new ListNode(8);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = null;
//        l5.next = null;

        ListNode ans = swapPairs2(l1);

        ListNode p = ans;
        while(p != null){
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.println("null");
    }

    //使用递归
    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode p = head;
        ListNode q = head.next;
        p.next = swapPairs(q.next);
        q.next = p;
        return q;
    }

    //使用迭代(遍历）
    public static ListNode swapPairs2(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode h = new ListNode(-1);
        ListNode p = head;
        ListNode q = p.next;

        ListNode ans = head.next;

        while(true){
            p.next = q.next;
            q.next = p;
            h.next = q;
            h = p;
            if(p.next == null || p.next.next == null)
                break;
            p = p.next;
            q = p.next;
        }
        return ans;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}