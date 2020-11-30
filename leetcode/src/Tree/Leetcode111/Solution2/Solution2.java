package Tree.Leetcode111.Solution2;

import java.util.LinkedList;

/**
 * @author ：hodor007
 * @date ：Created in 2020/11/30
 * @description ：
 * @version: 1.0
 */
public class Solution2 {
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;

        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.addLast(root);
        int depth = 0;
        while(!stack.isEmpty()){
            depth++;
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = stack.pollFirst();
                if(treeNode.left == null && treeNode.right == null){
                    return depth;
                }
                if(treeNode.left != null){
                    stack.addLast(treeNode.left);
                }
                if(treeNode.right != null){
                    stack.addLast(treeNode.right);
                }
            }
        }
        return depth;
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