package Link.Leetcode92;

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //特判
        if(head == null)
            return head;

        //添加再前面的两个辅助节点
        ListNode newNewHead = new ListNode(-1);
        ListNode newHead = new ListNode(-1);
        newNewHead.next = newHead;
        newHead.next = head;

        ListNode pre = newNewHead;
        ListNode p = newHead;
        ListNode q = null;

        for (int i = 0; i < m; i++) {
            pre = pre.next;
            p = p.next;
        }
        //循环结束后p指向交换开始的节点

        ListNode end = p;//交换后，经过交换的那段链表的末尾
        q = p.next;
        int count = n - m;
        for (int i = count; i > 0; i--) {
            ListNode temp = q.next;
            q.next = p;
            p = q;
            q = temp;
        }

        //交换后,p是那段链表的头
        pre.next = p;
        //收尾
        end.next = q;
        return newHead.next;
    }

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

        Solution solution = new Solution();
        ListNode ansList = solution.reverseBetween(l1, 1, 4);
        ListNode p = ansList;
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