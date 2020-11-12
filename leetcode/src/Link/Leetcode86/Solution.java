package Link.Leetcode86;

import java.util.List;

/**
 * @author ：hodor007
 * @date ：Created in 2020/11/12
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null)
            return head;
        ListNode p = head;

        ListNode beforeHead = new ListNode(-1);
        ListNode afterHead = new ListNode(-1);
        beforeHead.next = null;
        afterHead.next = null;
        ListNode b = beforeHead;
        ListNode a = afterHead;
        while(p != null){
            ListNode _next = p.next;
            if(p.val < x){
                p.next = b.next;
                b.next = p;
                b = b.next;
            } else {
                p.next = a.next;
                a.next = p;
                a = a.next;
            }
            p = _next;
        }
        //连接两条链表
        b.next = afterHead.next;
        return beforeHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(2);
        ListNode l6 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = null;

        Solution solution = new Solution();
        ListNode ans = solution.partition(l1,0);
        ListNode p = ans;
        while(p != null){
            System.out.print(p.val + " ");
            p = p.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}