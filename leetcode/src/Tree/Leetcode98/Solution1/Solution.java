package Tree.Leetcode98.Solution1;

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
        boolean ans = dfs(root, Integer.MAX_VALUE,'l');
        return ans;
    }

    public boolean dfs(TreeNode root, int val, char direct){
        if(root == null){
            return true;
        }

        boolean f1 = false;
        if(direct == 'l'){
            f1 = val > root.val;
        } else {
            f1 = val < root.val;
        }

        boolean f2 = dfs(root.left, root.val, 'l');
        boolean f3 = dfs(root.right, root.val, 'r');
        return f1 && f2 && f3;
//        return val > root.val && dfs(root.left, root.val) && dfs(root.right, root.val);
    }

    public static void main(String[] args) {
        TreeNode t1  = new TreeNode(10);
        TreeNode t2  = new TreeNode(5);
        TreeNode t3  = new TreeNode(15);
        TreeNode t4  = new TreeNode(6);
        TreeNode t5  = new TreeNode(20);
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