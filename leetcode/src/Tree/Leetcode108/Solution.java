package Tree.Leetcode108;

/**
 * @author ：hodor007
 * @date ：Created in 2020/11/30
 * @description ：
 * @version: 1.0
 */

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = build(nums, 0, nums.length - 1);
        return root;
    }

    private TreeNode build(int[] nums,int left, int right){
        if(left > right){
            return null;
        }
        //得出中间节点
        int mid = left + (right - left) / 2;
        //建立中间节点
        TreeNode root = new TreeNode(nums[mid]);
        //建立左子树
        root.left = build(nums, left, mid - 1);
        //建立右子树
        root.right = build(nums, mid + 1, right);
        return root;
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