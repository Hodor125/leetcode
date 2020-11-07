package Link.Leetcode876;

public class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode f = head;
        ListNode s = head;
        while(f.next != null && f.next.next != null){
            s = s.next;
            f = f.next.next;
        }

        if(f.next == null)
            return s;
        else
            return s.next;
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
        ListNode ans = solution.middleNode(l1);
        System.out.println(ans.val);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}