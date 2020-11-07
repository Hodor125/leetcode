package Tree.Leecode145.reTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/*
二刷
 */
public class Solution {
    //迭代算法遍历，重点在于在回到根节点的时候判断是从左还是从右回到根节点的，如果是右边则直接弹出n
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        HashSet<TreeNode> set = new HashSet<>();

        while(root != null || !stack.isEmpty()) {
            //最左为空了，看右边的节点呗
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            //查看右节点是否存在，存在就转向右节点(不弹出），并且把根节点存入set标记（表示已经从左节点来过了）
            TreeNode t = stack.peek();
            if (t.right != null) {
                if(set.contains(t)){
                    TreeNode temp = stack.pop();
                    list.add(temp.val);
                    root = null;
                }else{
                    set.add(t);
                    root = t.right;
                }
            }else {
                //右节点为空
                TreeNode temp = stack.pop();
                list.add(temp.val);
                root = null;
            }

        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(2);

        t1.left = t2;
        t1.right = t3;
        t2.left = null;
        t2.right = null;
        t3.left = null;
        t3.right = null;

        Solution solution = new Solution();
        List<Integer> ans = solution.postorderTraversal(t1);
        System.out.println(ans);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}