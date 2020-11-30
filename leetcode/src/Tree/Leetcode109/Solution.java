package Tree.Leetcode109;

/**
 * @author ：hodor007
 * @date ：Created in 2020/11/30
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        //找出中间节点
        if(head == null)
            return null;
        ListNode mid = findMid(head);

        //建立根节点
        TreeNode root = new TreeNode(mid.val);

        //建立右子树
        root.right = sortedListToBST(mid.next);

        //建立左子树
        //找出中间节点的前一个节点
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode pre = newHead;
        while(pre != null && pre.next != mid){
            pre = pre.next;
        }
        //取出用作左子树的链表
        pre.next = null;
        if(pre == newHead){
            root.left = sortedListToBST(null);
        } else {
            root.left = sortedListToBST(head);
        }
        return root;
    }

    //寻找中间节点的前一个节点
    private ListNode findMid(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next!= null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(10);
        ListNode l2 = new ListNode(-3);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(9);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = null;
        Solution solution = new Solution();
        TreeNode root = solution.sortedListToBST(l1);
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

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}