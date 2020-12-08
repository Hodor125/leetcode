package Link.Leetcode148.Solution1;

import java.util.List;

/**
 * @author ：hodor007
 * @date ：Created in 2020/12/7
 * @description ：
 * @version: 1.0
 */
class Solution {
    public ListNode sortList(ListNode head) {
        //递归终止条件
        if (head == null || head.next == null)
            return head;
        //取中点
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        //一刀切
        slow.next = null;
        //继续分
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        //排序
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
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