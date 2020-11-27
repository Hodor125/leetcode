package Tree.Leetcode106;

import java.util.HashMap;

/**
 * 创建哈希表方便查找中序遍历根节点的值
 * @author ：hodor007
 * @date ：Created in 2020/11/27
 * @description ：
 * @version: 1.0
 */
public class Solution {
    private HashMap<Integer, Integer> map = null;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = postorder.length;
        map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(inorder[i], i);
        }
        TreeNode treeNode = build(inorder, postorder, 0, len - 1, 0, len - 1);
        return treeNode;
    }

    private TreeNode build(int[] inorder, int[] postorder, int inOrderLeft, int inOrderRight, int postOrderLeft, int postOrderRight){
        //循环终止的条件，待调整
        if(postOrderLeft > postOrderRight){
            return null;
        }

        //根节点的值
        int rootVal = postorder[postOrderRight];
        //中序序列中根节点的索引
        int inOrderRoot = map.get(rootVal);
        //右子树的节点的数目
        int rightTreeNodeNum = inOrderRight - inOrderRoot;
        //创建根节点
        TreeNode treeNode = new TreeNode(rootVal);
        //创建右子树
        treeNode.right = build(inorder, postorder, inOrderRoot + 1, inOrderRight, postOrderRight - rightTreeNodeNum, postOrderRight - 1);
        //创建左子树
        treeNode.left = build(inorder, postorder, inOrderLeft, inOrderRoot - 1, postOrderLeft, postOrderRight - rightTreeNodeNum - 1);
        //返回创建的子树
        return treeNode;
    }

    private void travelInorder(TreeNode treeNode){
        if(treeNode == null){
            return;
        }

        travelInorder(treeNode.left);
        System.out.print(treeNode.val + " ");
        travelInorder(treeNode.right);
    }

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        Solution solution = new Solution();
        TreeNode treeNode = solution.buildTree(inorder, postorder);
        solution.travelInorder(treeNode);
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