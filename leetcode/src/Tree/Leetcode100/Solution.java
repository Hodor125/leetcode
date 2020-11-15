package Tree.Leetcode100;

/**
 * @author ：hodor007
 * @date ：Created in 2020/11/16
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p,q);
    }

    private boolean dfs(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }

        if(p == null && q != null || p != null && q == null || p.val != q.val){
            return false;
        }
        return dfs(p.left,q.left) && dfs(p.right,q.right);
    }

    public static void main(String[] args) {
        TreeNode t11 = new TreeNode(1);
        TreeNode t12 = new TreeNode(2);
        TreeNode t13 = new TreeNode(3);
        t11.left = t12;
        t11.right = t13;
        t12.left = null;
        t12.right = null;
        t13.left = null;
        t13.right = null;

        TreeNode t21 = new TreeNode(1);
        TreeNode t22 = new TreeNode(2);
        TreeNode t23 = new TreeNode(3);
        t21.left = t22;
        t21.right = t23;
        t22.left = null;
//        t22.right = null;
        t23.left = null;
        t23.right = null;
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