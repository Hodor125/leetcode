package Tree.Leetcode107;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * BFS倒过来罢了
 * @author ：hodor007
 * @date ：Created in 2020/11/27
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        //特判
        if(root == null){
            return ans;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.addLast(root);
        while(!stack.isEmpty()){
            List<Integer> subAns = new ArrayList<>();
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = stack.pollFirst();
                subAns.add(treeNode.val);
                if(treeNode.left != null){
                    stack.addLast(treeNode.left);
                }
                if(treeNode.right != null){
                    stack.addLast(treeNode.right);
                }
            }
            ans.addFirst(subAns);
        }
        return ans;
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