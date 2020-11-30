package Tree.Leetcode111.Solution1;

/**
 * DFS
 * @author ：hodor007
 * @date ：Created in 2020/11/30
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public int minDepth(TreeNode root) {
        int depth = dfs(root);
        return depth;
    }

    private int dfs(TreeNode root){
        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null){
            return 1;
        }

        int minVal = Integer.MAX_VALUE;
        if(root.left != null){
            minVal = Math.min(minVal, dfs(root.left));
        }
        if(root.right != null){
            minVal = Math.min(minVal, dfs(root.right));
        }
        return minVal + 1;
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
}