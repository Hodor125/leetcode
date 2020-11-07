package Tree.Leecode404.dfs;

public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null)
            return 0;
        int ans = dfs(root);
        return ans;
    }

    //高端写法
    public int dfs(TreeNode root){
        int ans = 0;
        //循环终止条件
        if(root == null)
            return ans;

        //先遍历左子树在遍历右边子树
        if(root.left != null)
            ans += judge(root.left) ? root.left.val : dfs(root.left);

        if(root.right != null)
            ans += dfs(root.right);
        return ans;
    }

    public boolean judge(TreeNode root){
        if(root.left == null && root.right == null)
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
