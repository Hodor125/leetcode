package Tree.Leecode102;

import java.util.ArrayDeque;
import java.util.ArrayList;
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

/*
bfs的适用场景，见精选回答
https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/bfs-de-shi-yong-chang-jing-zong-jie-ceng-xu-bian-l/
 */

public class Solution {
    static List<List<Integer>> res = new ArrayList<>();
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

        List<List<Integer>> ans = levelOrder2(t1);
        System.out.println("[");
        for (List<Integer> level : ans) {
            System.out.print("[");
            for (Integer integer : level) {
                System.out.print(integer);
                System.out.print(" ");
            }
            System.out.println("]");
        }
        System.out.println("]");
    }

    //BFS
    public static List<List<Integer>> levelOrder1(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();

        ArrayDeque<TreeNode> que = new ArrayDeque<>();

        if(root != null)
                que.add(root);
        while(!que.isEmpty()){
            List<Integer> newList = new ArrayList<>();
            int n = que.size();

            for (int i = 0; i < n; i++) {
                TreeNode temp = que.poll();
                newList.add(temp.val);
                if(temp.left != null)
                    que.add(temp.left);
                if(temp.right != null)
                    que.add(temp.right);
            }

            res.add(newList);
        }
        return res;
    }


    //DFS
    public static List<List<Integer>> levelOrder2(TreeNode root){
        if(root == null)
            return res;
        dfs(res,root,0);
        return res;
    }

    public static void dfs(List<List<Integer>> res, TreeNode root, int level){
        if(res.size() -1 < level)
            res.add(new ArrayList<Integer>());

        res.get(level).add(root.val);
        if(root.left != null)
            dfs(res,root.left,level + 1);
        if(root.right != null)
            dfs(res,root.right,level + 1);
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
