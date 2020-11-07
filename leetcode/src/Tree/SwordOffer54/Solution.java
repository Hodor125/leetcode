package Tree.SwordOffer54;

public class Solution {
    int k,res;
    public int kthLargest(TreeNode root, int count) {
        //忘记先复赋值导致错误
        this.k = count;
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root){
        if(root == null)
            return;
        dfs(root.right);

        //如果已经找到，则停止
        if(k == 0)
            return;

        if(--k == 0)
            this.res = root.val;

        dfs(root.left);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);

        t3.left = t1;
        t3.right = t4;
        t4.left = null;
        t4.right = null;
        t1.left = null;
        t1.right = t2;
        t2.left = null;
        t2.right = null;

        Solution s = new Solution();
        int i = s.kthLargest(t3, 2);
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