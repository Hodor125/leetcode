package Tree.Leecode145.solution1;

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

        List<Integer> ans = postorderTraversal(t1);
//        for (Integer an : ans) {
//            System.out.println(ans + " ");
//        }
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if(root == null)
            return res;
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            if(temp.left != null)
                stack.push(temp.right);
            if(temp.right != null)
                stack.push(temp.left);
            res.add(temp.val);
            System.out.println(temp.val);
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