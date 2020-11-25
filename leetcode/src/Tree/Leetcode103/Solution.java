package Tree.Leetcode103;

import java.util.*;

/**
 * BFS后反转
 * @author ：hodor007
 * @date ：Created in 2020/11/24
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }

        boolean reverse = false;
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.addLast(root);
        while(!nodes.isEmpty()){
            int size = nodes.size();
            List<Integer> subAns = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = nodes.pollFirst();
                subAns.add(treeNode.val);
                if(treeNode.left != null){
                    nodes.addLast(treeNode.left);
                }
                if(treeNode.right != null){
                    nodes.addLast(treeNode.right);
                }
            }
            if(reverse){
                Collections.reverse(subAns);
            }
            ans.add(subAns);
            //下一次是否反转
            reverse = !reverse;
        }
        return ans;
    }

    public static void main(String[] args) {

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