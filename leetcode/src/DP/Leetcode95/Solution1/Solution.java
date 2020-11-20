package DP.Leetcode95.Solution1;

import java.util.LinkedList;
import java.util.List;

/**
 * 题解
 * 考虑过动态规划，太天真了，要多大的表
 * 递归，考虑如何设计结束的条件，如何组合
 * 要递归 + 循环才能解决
 * @author ：hodor007
 * @date ：Created in 2020/11/20
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<TreeNode>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        // 枚举可行根节点
        for (int i = start; i <= end; i++) {
            // 获得所有可行的左子树集合
            List<TreeNode> leftTrees = generateTrees(start, i - 1);

            // 获得所有可行的右子树集合
            List<TreeNode> rightTrees = generateTrees(i + 1, end);

            // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);
                }
            }
        }
        return allTrees;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<TreeNode> treeNodes = solution.generateTrees(3);
        for (TreeNode treeNode : treeNodes) {
            solution.travel(treeNode);
            System.out.println();
        }
    }

    private void travel(TreeNode t){
        if(t == null){
            System.out.print("null ");
            return;
        }
        System.out.print(t.val + " ");
        travel(t.left);
        travel(t.right);
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