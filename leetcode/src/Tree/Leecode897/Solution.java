package Tree.Leecode897;

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
public class Solution {
    public static TreeNode cur;
    public TreeNode increasingBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        travel(root,list);

        TreeNode t = new TreeNode(0),res = t;

        for (Integer integer : list) {
            t.right = new TreeNode(integer);
            t = t.right;
        }

        return res.right;
    }

    //中序+直接构建
    public TreeNode increasingBST2(TreeNode root){
        if(root == null)
            return root;

        TreeNode ans = new TreeNode(0);
        cur = ans;
        travel2(root);
        return ans.right;
    }

    //中序遍历+构建树
    public static void travel(TreeNode root, List<Integer> list){
        if(root == null)
            return;
        if(root.left != null)
            travel(root.left, list);
        list.add(root.val);
        if(root.right != null)
            travel(root.right,list);
    }

    public static void travel2(TreeNode root){
        if(root == null)
            return;

        travel2(root.left);
        root.left = null;
        cur.right = root;
        cur = root;
        travel2(root.right);
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