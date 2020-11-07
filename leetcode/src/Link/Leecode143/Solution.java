package Link.Leecode143;

import java.util.List;
import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = null;

        reorderList(l1);

        ListNode p = l1;
        while (p != null){
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.println("null");
    }

    public static void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;

        Stack<ListNode> stack = new Stack<>();
        ListNode p = head.next;
        while(p != null){
            stack.push(p);
            p = p.next;
        }

        p = head;
        while(!stack.isEmpty()){
            ListNode temp = stack.pop();
//            System.out.println(temp.val);
            p.next = temp;
            p = p.next;
        }
        p.next = null;
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