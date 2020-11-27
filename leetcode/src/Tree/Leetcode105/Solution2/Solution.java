package Tree.Leetcode105.Solution2;

import java.util.HashMap;

/**
 * 中序遍历的序列建立哈希表，减少寻找索引的时间
 * @author ：hodor007
 * @date ：Created in 2020/11/27
 * @description ：
 * @version: 1.0
 */
public class Solution {
    private HashMap<Integer, Integer> map = null;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<Integer, Integer>();
        int len = inorder.length;
        for (int i = 0; i < len; i++) {
            map.put(inorder[i], i);
        }
        TreeNode treeNode = build(preorder, inorder, 0, len - 1, 0, len - 1);
        return treeNode;
    }

    private TreeNode build(int[] preorder, int[] inorder, int preorderLeft, int preorderRight,int inorderLeft, int inorderRight){
        //循环终止的条件
        if(preorderLeft > preorderRight){
            return null;
        }

        //获得根节点的值
        int rootVal = preorder[preorderLeft];
        //获得根节点的中序索引
        int intOrderRoot = map.get(rootVal);
        //创建根节点
        TreeNode root = new TreeNode(rootVal);
        //左子树的节点数量，中序根节点索引减去左节点索引
        int leftTreeNodeNum = intOrderRoot - inorderLeft;
        //创建左子树
        root.left = build(preorder, inorder, preorderLeft + 1, preorderLeft + leftTreeNodeNum, inorderLeft, inorderRight - 1);
        //创建右子树
        root.right = build(preorder, inorder, preorderLeft + leftTreeNodeNum + 1, preorderRight, intOrderRoot + 1, inorderRight);
        //返回创建好的子树
        return root;
    }

    private void inOrderTravel(TreeNode treeNode){
        if(treeNode == null){
            return;
        }

        inOrderTravel(treeNode.left);
        System.out.print(treeNode.val + " ");
        inOrderTravel(treeNode.right);
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        Solution solution = new Solution();
        TreeNode treeNode = solution.buildTree(preorder, inorder);
        new Solution().inOrderTravel(treeNode);
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