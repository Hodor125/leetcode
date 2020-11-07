package Link;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/*
比较典型的双指针游走题目，设有两个指针 p,q ：

初始时，两个指针均指向 head。
先将 q 向后移动 k 次。此时p，q的距离为 k。
同时移动 p，q, 直到 q 指向 nullptr。此时p->val即为答案。
 */

public class Interview_0202 {
    public static void main(String[] args) {
        ListNode0202 head = new ListNode0202(1);
        head.next = new ListNode0202(2);
        head.next.next = new ListNode0202(3);
        head.next.next.next = new ListNode0202(4);
        head.next.next.next.next = new ListNode0202(5);
        System.out.println("倒数第二个：" + Interview_0202.kthToLast(head,2));
    }
    public static int kthToLast(ListNode0202 head, int k) {
        ListNode0202 p = head;
        for (int i = 0; i < k; i++)
            p = p.next;
        while(p != null){
            head = head.next;
            p = p.next;
        }
        return head.val;
    }
}

 class ListNode0202 {
      int val;
      ListNode0202 next;
      ListNode0202(int x) { val = x; }
  }