package Tree.Leecode404.bfs;

import java.util.LinkedList;

public class Solution {
    /*
    广度优先遍历，借助队列实现
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null)
            return 0;

        int sum = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode t = queue.poll();
                if(judge(t.left))
                    sum += t.left.val;

                if(t.left != null)
                    queue.offer(t.left);
                if(t.right != null)
                    queue.offer(t.right);
            }
        }
        return sum;
    }

    public boolean judge(TreeNode t){
        if(t != null && t.left == null && t.right == null)
            return true;
        return false;
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

        Solution solution = new Solution();
        int i = solution.sumOfLeftLeaves(t1);
        System.out.println(i);
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