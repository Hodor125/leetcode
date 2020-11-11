package Link.Leetcode83;

import java.util.List;

/**
 * @author ：hodor007
 * @date ：Created in 2020/11/11
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return head;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode pre = newHead;
        ListNode p = head;
        ListNode q = p.next;
        //当后面的指针不为空
        while(q != null){
            if(p.val == q.val){
                pre.next = q;
                p = q;
                q = q.next;
                continue;
            }
            pre = pre.next;
            p = p.next;
            q = q.next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = null;
        ListNode ans = solution.deleteDuplicates(l1);
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