package Tree.Leetcode98.Solution3;

/**
 * 递归判断
 * 利用了Integer是对象可以为空的特性
 * @author ：hodor007
 * @date ：Created in 2020/11/24
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        boolean ans = helper(root, null, null);
        return ans;
    }

    public boolean helper(TreeNode root, Integer lower, Integer upper){
        if(root == null){
            return true;
        }

        if(lower != null && root.val <= lower){
            return false;
        }

        if(upper != null && root.val >= upper){
            return false;
        }

        boolean f1 = helper(root.left,lower,root.val);
        boolean f2 = helper(root.right,root.val,upper);
        return f1 && f2;
    }

    public static void main(String[] args) {
//        TreeNode t1  = new TreeNode(10);
//        TreeNode t2  = new TreeNode(5);
//        TreeNode t3  = new TreeNode(15);
//        TreeNode t4  = new TreeNode(6);
//        TreeNode t5  = new TreeNode(20);
//        t1.left = t2;
//        t1.right = t3;
//        t2.left = null;
//        t2.right = null;
//        t3.left = t4;
//        t3.right = t5;
//        t4.left = null;
//        t4.right = null;
//        t5.left = null;
//        t5.right = null;

        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        t2.left = null;
        t2.right = null;
        t3.left = null;
        t3.right = null;

        Solution solution = new Solution();
        boolean validBST = solution.isValidBST(t1);
        System.out.println(validBST);
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