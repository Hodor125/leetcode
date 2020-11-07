package Link.Leecode445;


import java.util.List;
import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

/*
输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 8 -> 0 -> 7
 */
public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = null;

        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(6);
        ListNode n3 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = null;

        ListNode ans = addTwoNumbers2(l1, n1);
        print(ans);
    }
    public static void print(ListNode head){
        ListNode p = head;
        while(p != null){
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.println("null");
    }

    //使用栈+头插法
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();

        ListNode p = l1;
        ListNode q = l2;
        ListNode head = new ListNode(-1);
        head.next = null;

        while(p != null){
            s1.push(p);
            p = p.next;
        }
        while(q != null){
            s2.push(q);
            q = q.next;
        }

        int c = 0;
        while(!s1.isEmpty() || !s2.isEmpty() || c > 0){
            int sum = (s1.isEmpty() ? 0 : s1.pop().val) + (s2.isEmpty() ? 0 : s2.pop().val) + c;
            c = sum / 10;
            int re = sum % 10;
            ListNode l = new ListNode(re);
            l.next = head.next;
            head.next = l;
        }
        return head.next;
    }

    //链表反转+头插法
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2){
        ListNode list1 = new ListNode(-1);
        list1.next = null;
        ListNode list2 = new ListNode(-1);
        list2.next = null;

        ListNode p = l1;
        ListNode q = l2;

        //使用新的链表存储反转的链表
        while(p != null){
            ListNode temp = new ListNode(p.val);
            temp.next = list1.next;
            list1.next = temp;
            p = p.next;
        }
        while(q != null){
            ListNode temp = new ListNode(q.val);
            temp.next = list2.next;
            list2.next = temp;
            q = q.next;
        }

        //和链表使用头插法插入新链表
        ListNode relist1 = list1.next;
        ListNode relist2 = list2.next;
        ListNode head = new ListNode(-1);//和链表存储
        head.next = null;
        p = relist1;
        q = relist2;
        int c = 0;
        while(p != null || q != null || c > 0){
            int sum = (p == null ? 0 : p.val) + (q == null ? 0 : q.val) + c;
            int re = sum % 10;
            c = sum / 10;
            ListNode t = new ListNode(re);
            t.next = head.next;
            head.next = t;
            if(p != null)
                p = p.next;
            if(q != null)
                q = q.next;
        }
        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
