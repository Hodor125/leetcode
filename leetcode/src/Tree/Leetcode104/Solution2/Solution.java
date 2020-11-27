package Tree.Leetcode104.Solution2;

/**
 * 使用递归
 *
 * @author ：hodor007
 * @date ：Created in 2020/11/25
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Integer.max(maxDepth(root.left),maxDepth(root.right)) + 1;
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