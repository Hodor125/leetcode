package DP.Leetcode95.Solution2;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ：hodor007
 * @date ：Created in 2020/11/20
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0){
            List<TreeNode> treeNodes = new LinkedList<>();
            return treeNodes;
        }
        List<TreeNode> trees = getTrees(1, n);

        return trees;
    }

    private List<TreeNode> getTrees(int start, int end){
        List<TreeNode> allTrees = new LinkedList<>();
        if(start > end){
            allTrees.add(null);
            return allTrees;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = getTrees(start, i - 1);
            List<TreeNode> rightTrees = getTrees(i + 1, end);
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    allTrees.add(root);
                }
            }
        }

        return allTrees;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<TreeNode> treeNodes = solution.generateTrees(0);
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