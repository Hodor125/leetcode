package Link.Leecode142;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */

public class Leecode142 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(-4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;

        ListNode ans = detectCycle2(l1);
        System.out.println(ans.val);

//        System.out.println(l1.val);
//        print(l1);
    }

    public static void print(ListNode head){
        ListNode p = head;
        int i = 0;
        while(p != null){
            System.out.print(p.val + "->");
            p = p.next;
            i++;
            if(i == 9)
                break;
        }
    }

    /*
    方法一：使用HashMap
     */
    //！！！指针循环记得后移！！！！
    public static ListNode detectCycle1(ListNode head) {
        HashSet<ListNode> visited = new HashSet<>();
        ListNode p = head;
        while (p != null) {
            if(visited.contains(p))
                return p;
            visited.add(p);
            p = p.next;
        }
        return null;
    }

    /*
    方法二：双指针
    见题解
     */

    public static ListNode getIntersect(ListNode head){
        ListNode hare = head;
        ListNode tortoise = head;
        while(hare != null && tortoise != null && hare.next != null){
            hare = hare.next.next;
            tortoise = tortoise.next;
            if(hare == tortoise){
//                System.out.println(tortoise.val);
                return tortoise;
            }
        }
        return null;
    }

    public static ListNode detectCycle2(ListNode head){
        if(head == null)
            return null;
        if(getIntersect(head) == null)
            return null;
        ListNode temp = getIntersect(head);
        ListNode p = head;
        while(p != temp){
            p = p.next;
            temp = temp.next;
        }
        return p;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
