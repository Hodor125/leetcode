package Tree.Leecode637;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.DelayQueue;

public class Solution {
    public List<Double> list = new ArrayList<>();

    public List<Double> averageOfLevels(TreeNode root) {
        if(root == null)
            return list;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int num = queue.size();
            long sum = 0;
            for (int i = 0; i < num; i++) {
                TreeNode t = queue.poll();
                sum += t.val;
                if(t.left != null)
                    queue.add(t.left);
                if(t.right != null)
                    queue.add(t.right);
            }
            double res = (double)sum / num;
            list.add(res);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);

        t1.left = t2;
        t1.right = t3;
        t2.left = null;
        t2.right = null;
        t3.left = t4;
        t3.right = t5;
        t4.left = null;
        t4.right = null;
        t5.left = null;
        t5.right = null;

        List<Double> ans = new Solution().averageOfLevels(t1);
        System.out.println(ans);
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