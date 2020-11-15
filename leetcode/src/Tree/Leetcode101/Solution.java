package Tree.Leetcode101;

/**
 * @author ：hodor007
 * @date ：Created in 2020/11/16
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root,root);
    }

    private boolean dfs(TreeNode l,TreeNode r){
        if(l == null && r == null){
            return true;
        }

        if(l == null || r == null){
            return false;
        }

        return l.val == r.val && dfs(l.left,r.right) && dfs(l.right,r.left);
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