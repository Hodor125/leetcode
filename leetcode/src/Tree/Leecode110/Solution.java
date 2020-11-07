package Tree.Leecode110;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);

        t1.left = t2;
        t1.right = t3;
        t2.left = null;
        t2.right = null;
        t3.left = t4;
        t3.right = t5;
        t4.left = null;
        t4.right = null;
        t5.left = null;
        t5.right = null;

        boolean flag = isBalanced2(t1);
        System.out.println(flag);
    }

    //类似前序遍历，计算当前节点是否平衡在计算左右子树，从上到下
    public static boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        return (Math.abs(height(root.left) - height(root.right)) <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }

    public static int height(TreeNode root){
        if(root == null)
            return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static boolean isBalanced2(TreeNode root){
        int height = height2(root);
        if(height >= 0)
            return true;
        return false;
    }

    //从下到上
    public static int height2(TreeNode root){
        if(root == null)
            return 0;
        int l = height2(root.left);
        int r = height2(root.right);
        if(l == -1 || r == -1 || Math.abs(l - r) > 1)
            return -1;
        return Math.max(l, r) + 1;
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
