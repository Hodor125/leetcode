package Tree.SwordOffer32;


import java.util.ArrayList;
import java.util.LinkedList;
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
    static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        travel(root,queue);
        return res;
    }

    public void travel(TreeNode root,LinkedList<TreeNode> queue){
        int len = queue.size();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            TreeNode t = queue.pollFirst();
            list.add(t.val);

            if(t.left != null)
                queue.add(t.left);
            if(t.right != null)
                queue.add(t.right);
        }
        res.add(list);
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