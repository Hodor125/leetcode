package Tree.Leecode872;

import java.util.ArrayList;

public class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        dfs(root1,list1);
        dfs(root2,list2);
        return list1.equals(list2);
    }

    public void dfs(TreeNode root,ArrayList<Integer> list){
        if(root != null){
            dfs(root.left,list);
            if(root.left == null && root.right == null)
                list.add(root.val);
            dfs(root.right,list);
        }
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