package Tree.Leetcode114;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * 遍历到数组里面然后再遍历一次
 * @author ：hodor007
 * @date ：Created in 2020/12/1
 * @description ：
 * @version: 1.0
 */
public class Solution {
    private ArrayList<TreeNode> preList;

    public void flatten(TreeNode root) {
        //特判
        if (root == null){
            return;
        }

        preList = new ArrayList<>();
        preTravel(root);
        int len = preList.size();
        for (int i = 0; i < len; i++) {
            if(i + 1 < len){
                preList.get(i).left = null;
                preList.get(i).right = preList.get(i + 1);
            } else {
                preList.get(i).left = null;
                preList.get(i).right = null;
            }
        }
    }

    private void preTravel(TreeNode root){
        if(root == null){
            return;
        }

        preList.add(root);
        preTravel(root.left);
        preTravel(root.right);
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