package Tree.SwordOffer54.Solution2;

/**
 * 中序遍历是从小到大，需要倒过来
 * @author ：hodor007
 * @date ：Created in 2021/3/24
 * @description ：
 * @version: 1.0
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    int k, res;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if(root == null)
            return;
        dfs(root.right);
        if(k == 0)
            return;
        if(--k == 0)
            res = root.val;
        dfs(root.left);
    }
}
