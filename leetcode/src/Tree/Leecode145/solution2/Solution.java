package Tree.Leecode145.solution2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
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

    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<TreeNode> set = new HashSet<>();

        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }

            //不直接弹出，查看栈顶的右节点进行判断
            //ArrayDeque的peek是查看栈顶，jdk8的中文文档似乎有误
            root = stack.peek();

            if(set.contains(root) || root.right == null){
                //栈顶弹出，如果为空就可以结束了,root设置为null防止循环回到上面的语句时继续插入重复节点
                root = stack.pop();
                list.add(root.val);
                root = null;
            } else {
                //因为是后序遍历，不能直接弹出栈顶进行转移
                //添加进set表示访问过，转到右子树
                set.add(root);
                root = root.right;
            }
        }
        return list;
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