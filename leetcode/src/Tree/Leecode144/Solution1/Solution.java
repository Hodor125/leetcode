package Tree.Leecode144.Solution1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
        t1.left = null;
        t1.right = t2;
        t2.left = t3;
        t2.right = null;
        t3.left = null;
        t3.right = null;

        List<Integer> ans = preorderTraversal2(t1);
        for (Integer an : ans) {
            System.out.print(an + " ");
        }
    }

    //使用递归
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(res, root);
        return res;
    }

    public static void helper(List<Integer> res, TreeNode root){
        if(root == null)
            return;

        res.add(root.val);

        if(root.left != null)
            helper(res,root.left);
        if(root.right != null)
            helper(res, root.right);
    }

    //使用迭代
    public static List<Integer> preorderTraversal2(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null)
            return res;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            res.add(temp.val);
//            System.out.println("node:" + temp.val);
            if(temp.right != null){
                stack.push(temp.right);
//                System.out.println("add right");
            }
            if(temp.left != null){
                stack.push(temp.left);
//                System.out.println("add left");
            }
        }
        return res;
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
