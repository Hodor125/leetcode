package Tree.Leecode404.myDfs;

public class Solution {
    private int ans = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null)
            return 0;
        travel(root);
        return ans;
    }

    public void travel(TreeNode root){
        if(root == null)
            return;
        if(root.left != null && root.left.left == null && root.left.right == null)
            ans += root.left.val;
        travel(root.left);
//        System.out.println(root.val);
        travel(root.right);
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