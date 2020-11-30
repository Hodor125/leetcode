package Tree.Leetcode112;

/**
 * @author ：hodor007
 * @date ：Created in 2020/11/30
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        boolean ans = dfs(root, 0, sum);
        return ans;
    }

    private boolean dfs(TreeNode root, int sum, int target){
        if (root == null){
            return false;
        }

        if(root.left == null && root.right == null){
            sum += root.val;
            if(sum == target){
                return true;
            } else {
                return false;
            }
        }

        if(root.left != null && root.right == null){
            return dfs(root.left, sum + root.val, target);
        }

        if(root.right != null && root.left == null){
            return dfs(root.right, sum + root.val, target);
        }

        return dfs(root.left, sum + root.val, target) || dfs(root.right, sum + root.val, target);
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