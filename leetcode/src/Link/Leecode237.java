package Link;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

/*
因为，我们无法访问我们想要删除的节点 之前 的节点，我们始终不能修改该节点的 next 指针。
相反，我们必须将想要删除的节点的值替换为它后面节点中的值，然后删除它之后的节点。
 */
public class Leecode237 {
    public static void deleteNode(ListNode237 node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        ListNode237 l1 = new ListNode237(4);
        ListNode237 l2 = new ListNode237(5);
        ListNode237 l3 = new ListNode237(1);
        ListNode237 l4 = new ListNode237(9);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = null;

        Leecode237.deleteNode(l2);

        ListNode237 p = l1;
        while(p != null){
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.println("null");
    }
}

class ListNode237 {
    int val;
    ListNode237 next;

    ListNode237(int x) {
        val = x;
    }
}