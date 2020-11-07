package Tree.Interview0404;

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
dfs+dp
隐性动态规划，父节点的平衡性根据子节点得到
用标志位 flag 捕获结果
 */

public class Solution {
    private static boolean flag = true;

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(3);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(4);

        t1.left = t2;
        t1.right = t3;
        t3.left = null;
        t3.right = null;
        t2.left = t4;
        t2.right = t5;
        t5.left = null;
        t5.right = null;
        t4.left = t6;
        t4.right = t7;
        t6.left = null;
        t6.right = null;
        t7.left = null;
        t7.right = null;

        TreeNode t = new TreeNode(1);
        t.left = null;
        t.right = null;

        boolean f = isBalanced(t);
        System.out.println("is balanced ? " + f);
    }

    public static boolean isBalanced(TreeNode root) {
        dfs(root);
        return flag;
    }

    private static int dfs(TreeNode n){
        if(n == null || !flag){
            return 0;
        }

        int leftH = dfs(n.left) + 1;
        int rightH = dfs(n.right) + 1;
        if(Math.abs(leftH - rightH) > 1)
            flag = false;
        return Math.max(leftH, rightH);
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