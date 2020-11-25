package Tree.Leetcode104;

import java.util.LinkedList;

/**
 * BFS直接搞
 * @author ：hodor007
 * @date ：Created in 2020/11/24
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.addLast(root);
        int depth = 0;
        while(!nodes.isEmpty()){
            depth++;
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = nodes.pollFirst();
                if(treeNode.left != null){
                    nodes.addLast(treeNode.left);
                }
                if(treeNode.right != null){
                    nodes.addLast(treeNode.right);
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

    TreeNode(int x) {
        val = x;
    }
}