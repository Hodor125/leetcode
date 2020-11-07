package Link.Leecode142.Solution1;

import jdk.nashorn.internal.objects.NativeUint8Array;

import java.util.HashSet;

/**
 * 二刷
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<ListNode>();

        ListNode p = head;
        while(p != null){
            if(set.contains(p.next))
                return p.next;
            set.add(p);
            p = p.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(-4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;

        Solution solution = new Solution();
        ListNode listNode = solution.detectCycle(l1);
        System.out.println(listNode.val);
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