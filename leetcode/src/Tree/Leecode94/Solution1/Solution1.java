package Tree.Leecode94.Solution1;

import java.util.ArrayList;
import java.util.List;

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
中序遍历
 */
public class Solution1 {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root != null)
            helper(root, list);
        return list;
    }

    public static void helper(TreeNode root, List<Integer> res) {
        if(root.left != null)
            helper(root.left, res);
//        System.out.println("add:" + root.val);
        res.add(root.val);
        if(root.right != null)
            helper(root.right, res);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);

        t1.left = null;
        t1.right = t2;
        t2.left = t3;
        t2.right = null;
        t3.left = null;
        t3.right = null;

        List<Integer> list = inorderTraversal(t1);
        for (Integer integer : list) {
            System.out.println(integer);
        }
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
