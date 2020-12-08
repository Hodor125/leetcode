package Link.Leetcode148.Solution4;

import java.util.List;

/**
 * @author ：hodor007
 * @date ：Created in 2020/12/8
 * @description ：
 * @version: 1.0
 */
class Solution {
    public ListNode sortList(ListNode head) {
        //计算链表的长度
        int len = 0;
        ListNode p = head;
        while(p != null){
            len++;
            p = p.next;
        }

        ListNode dummyHead = new ListNode(0,head);
        ListNode pre = null;
        ListNode curr = null;
        for (int subLen = 1; subLen < len; subLen <<= 1) {
            pre = dummyHead;
            curr = pre.next;
            while(curr != null){
                //取两段子序列
                ListNode head1 = curr;
                for (int i = 1; i < subLen && curr.next != null; i++) {
                    curr = curr.next;
                }

                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                for (int i = 1; i < subLen && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }

                //保存下一个节点（未排序）
                ListNode next = null;
                if(curr != null && curr.next != null){
                    next = curr.next;
                    curr.next = null;
                }

                //合并序列
                pre.next = merge(head1, head2);
                while(pre.next != null){
                    pre = pre.next;
                }
                //指向未排序的序列的首部
                curr = next;
            }
        }

        return dummyHead.next;
    }

    private ListNode merge(ListNode l1, ListNode l2){
        ListNode newHead = new ListNode(Integer.MAX_VALUE);
        ListNode p = newHead;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while(p1 != null && p2 != null){
            if(p1.val < p2.val){
                p.next = p1;
                p1 = p1.next;
                p = p.next;
            } else {
                p.next = p2;
                p = p.next;
                p2 = p2.next;
            }
        }

        if(p1 != null){
            p.next = p1;
        }

        if(p2 != null){
            p.next = p2;
        }

        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(8);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(6);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(1);
        ListNode l6 = new ListNode(2);
        ListNode l7 = new ListNode(3);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = null;

        Solution solution = new Solution();
        ListNode head = solution.sortList(l1);
        ListNode p = head;
        while(p != null){
            System.out.print(p.val + " ");
            p = p.next;
        }
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