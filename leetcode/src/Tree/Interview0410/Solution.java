package Tree.Interview0410;


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
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);

        t1.left = t2;
        t1.right = t3;
        t2.left = null;
        t2.right = null;
        t3.right = null;
        t3.left = null;

        boolean flag = checkSubTree(t1,t2);
        System.out.println(flag);
    }

    public static boolean isSame(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2 == null;
        if (t2 == null)
            return false;
        return t1.val == t2.val && isSame(t1.left, t2.left) && isSame(t1.right, t2.right);
    }

    public static boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2 == null;
        if (t2 == null)
            return false;
        return isSame(t1, t2) || checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
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
