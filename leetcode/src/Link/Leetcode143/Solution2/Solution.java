package Link.Leetcode143.Solution2;


import sun.plugin2.gluegen.runtime.StructAccessor;

/**
 * 没有看出规律，将后半段链表反转之后再跟前半段拼接
 */
public class Solution {
    public void reorderList(ListNode head) {
        //特判
        if(head == null || head.next == null || head.next.next == null)
            return;

        ListNode middle = findMiddle(head);
//        System.out.println("middle:" + middle.val);

        ListNode temp = middle.next;
        ListNode reverse = reverse(temp);
//        System.out.println("reverse");
//        travel(reverse);
        //分成两条链表
        middle.next = null;

//        System.out.println("original");
//        travel(head);


        ListNode merge = merge(head,reverse);
//        System.out.println("merge");
//        travel(merge);
        head = merge;
    }

    //找出链表的中点
    public ListNode findMiddle(ListNode head){
        ListNode f = head;
        ListNode s = head;
        while(f.next != null && f.next.next != null){
            s = s.next;
            f=  f.next.next;
        }

        //如果是长度是偶数，返回的是前一个节点
        return s;
    }

    //反转链表
    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode pre = null;
        ListNode nex = null;

        while(curr != null){
            nex = curr.next;
            curr.next = pre;
            pre = curr;
            curr = nex;
        }
        return pre;
    }

    //将两条链表个兵（仅限于第一条链表比第二条链表长1的情况）
    public ListNode merge(ListNode l1,ListNode l2){
        ListNode newHead = new ListNode(-1);
        newHead.next = l1;

        ListNode lp1 = null;
        ListNode lp2 = null;

        while(l1 != null && l2 != null){
            if(l1.next != null){
                lp1 = l1.next;
            } else {
                lp1 = null;
            }

            if(l2.next != null){
                lp2 = l2.next;
            } else {
                lp2 = null;
            }

            l1.next = l2;
            l2.next = lp1;

            l1 = lp1;
            l2 = lp2;
        }


        return newHead.next;
    }

    public void travel(ListNode head){
        ListNode p = head;

        while(p != null){
            System.out.println(p.val + " ");
            p = p.next;
        }
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
        solution.reorderList(l1);
        solution.travel(l1);

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