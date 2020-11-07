package Link.Leecode2;

import Greedy.Leecode135.Solution2;

import java.util.List;

public class Solution {
    public static void main(String[] args) {
//        ListNode l11 = new ListNode(2);
//        ListNode l12 = new ListNode(4);
//        ListNode l13 = new ListNode(3);
//        l11.next = l12;
//        l12.next = l13;
//        l13.next = null;
//
//        ListNode l21 = new ListNode(5);
//        ListNode l22 = new ListNode(6);
//        ListNode l23 = new ListNode(4);
//        l21.next = l22;
//        l22.next = l23;
//        l23.next = null;

        ListNode l11 = new ListNode(5);
        ListNode l12 = new ListNode(8);
        l11.next = l12;
        l12.next = null;

        ListNode l21 = new ListNode(0);
        l21.next = null;

        ListNode ans = new Solution().addTwoNumbers(l11, l21);
        ListNode p = ans;
        while(p != null){
            System.out.print(p.val+" ");
            p = p.next;
        }

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l2;
        ListNode ans = new ListNode(-1);
        ListNode p = l1;
        ListNode q = l2;
        ListNode r = ans;
        int carry = 0;//进位
        int remain = 0;//余数

        while(p != null && q != null){
            int sum = p.val + q.val + carry;
            carry = sum / 10;
            remain = sum % 10;
            ListNode t = new ListNode(remain);
            r.next = t;
            r = r.next;
            p = p.next;
            q = q.next;
        }

        if (carry != 0 && p == null && q == null){
            ListNode t = new ListNode(carry);
            r.next = t;
            r = r.next;
        }

        while(p != null){
            if(carry != 0){
                int sum = p.val + carry;
                carry = sum / 10;
                remain = sum % 10;
                ListNode t = new ListNode(remain);
                r.next = t;
                r = r.next;
                //再次产生进位
                if(carry != 0 && p.next == null){
                    t = new ListNode(carry);
                    r.next = t;
                    r = r.next;
                }

            } else {
                ListNode t = new ListNode(p.val);
                r.next = t;
                r = r.next;
            }
            p = p.next;
        }

        while(q != null){
            //另一条链不空
            if(carry != 0){
                int sum = q.val + carry;
                carry = sum / 10;
                remain = sum % 10;
                ListNode t = new ListNode(remain);
                r.next = t;
                r = r.next;

                if(carry != 0 && q.next == null){
                    t = new ListNode(carry);
                    r.next = t;
                    r = r.next;
                }

            } else {
                ListNode t = new ListNode(q.val);
                r.next = t;
                r = r.next;
            }
            q = q.next;
        }
        return ans.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}