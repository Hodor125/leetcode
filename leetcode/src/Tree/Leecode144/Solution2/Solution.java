package Tree.Leecode144.Solution2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null)
            return list;

        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode t = stack.pop();
            list.add(t.val);

            //先压入右节点，再压入左节点，这样弹栈遍历的顺序就是中左右
            if(t.right != null)
                stack.push(t.right);
            if(t.left != null)
                stack.push(t.left);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);

        t1.left = null;
        t1.right = t2;
        t2.left = t3;
        t2.right = null;
        t3.left = null;
        t3.right = null;

        List<Integer> ans = new Solution().preorderTraversal(t1);
        System.out.println(ans);
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