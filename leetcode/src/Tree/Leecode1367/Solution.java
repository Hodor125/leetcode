package Tree.Leecode1367;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

/*
用例不复杂的情况下带入用例进行调试
 */
public class Solution {
    public static void main(String[] args) {
        //head = [4,2,8]
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(8);

        l1.next = l2;
        l2.next = l3;
        l3.next = null;

        /*********************************/
        //root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
        TreeNode t1 = new TreeNode(1);

        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(4);

        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(2);

        TreeNode t6 = new TreeNode(1);
        TreeNode t7 = new TreeNode(6);
        TreeNode t8 = new TreeNode(8);

        TreeNode t9 = new TreeNode(1);
        TreeNode t10 = new TreeNode(3);

        t1.left = t2;
        t1.right = t3;
        t2.left = null;
        t2.right = t4;
        t3.left = t5;
        t3.right = null;

        t4.left = t6;
        t4.right = null;
        t5.left = t7;
        t5.right = t8;

        t6.left = null;
        t6.right = null;
        t7.left = null;
        t7.right = null;
        t8.left = t9;
        t8.right = t10;

        t9.left = null;
        t9.right = null;
        t10.left = null;
        t10.right = null;

        boolean flag = isSubPath(l1,t1);
        System.out.println(flag);

    }

    public static boolean isSubPath(ListNode head, TreeNode root) {
        if(head == null)
            return root == null;
        if(root == null)
            return false;
        return isSame(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    public static boolean isSame(ListNode node, TreeNode root){
        //链表走完了就是存在
        if(node == null)
            return true;
//            return root == null;
        if(root == null)
            return false;
        return node.val == root.val && (isSame(node.next, root.left) || isSame(node.next, root.right));
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}