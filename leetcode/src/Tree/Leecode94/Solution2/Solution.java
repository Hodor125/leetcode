package Tree.Leecode94.Solution2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Solution {
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

        List<Integer> ans = new Solution().inorderTraversal(t1);
        System.out.println(ans);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();

        if(root == null)
            return list;

        //注意终结条件的设定，画图分析会比较清晰，添加了root!=null的条件才能进入循环或者转移到右子树
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            //左子树已经遍历完成或者为空，右子树不为空则转移到右子树
            root = root.right;
        }
        return list;
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