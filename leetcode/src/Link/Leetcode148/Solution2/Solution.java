package Link.Leetcode148.Solution2;

/**
 * 使用递归
 * @author ：hodor007
 * @date ：Created in 2020/12/8
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        //递归终止条件，链表为空或者只有一个节点，则递归终止
        if(head == null || head.next == null){
            return head;
        }
        //快慢指针拆分
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //一刀切
        ListNode newList = slow.next;
        slow.next = null;
        //继续分
        ListNode listLeft = sortList(head);
        ListNode listRight = sortList(newList);
        //拼接
        ListNode newHead = new ListNode(Integer.MAX_VALUE);
        ListNode p = newHead;
        ListNode l = listLeft;
        ListNode r = listRight;
        while(l != null && r != null){
            if(l.val > r.val){
                p.next = r;
                p = p.next;
                r = r.next;
            } else {
                p.next = l;
                p = p.next;
                l = l.next;
            }
        }
        if(l != null){
            p.next = l;
        }
        if(r != null){
            p.next = r;
        }

        //返回拼接的链表
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