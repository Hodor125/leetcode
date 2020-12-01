package Tree.Leetcode113;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：hodor007
 * @date ：Created in 2020/12/1
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subAns = new ArrayList<>();
        dfs(root, ans, subAns, 0, sum);
        return ans;
    }

    private void dfs(TreeNode root,List<List<Integer>> ans, List<Integer> subAns, int sum, int target){
        //最初的根节点为空则直接返回
        if(root == null){
            return;
        }

        //如果左右子树都为空，如果等于目标值，则在ans中加上这个subAns，最后都要移除这个节点
        if(root.left == null && root.right == null){
            subAns.add(root.val);
            if(sum + root.val == target){
                ArrayList<Integer> _subAns = new ArrayList<>(subAns);
                ans.add(_subAns);
            }
            subAns.remove(subAns.size() - 1);
        }
        if(root.left != null){
            subAns.add(root.val);
            sum += root.val;
            dfs(root.left, ans, subAns, sum, target);
            //回溯回来的时候要移除状态
            sum -= root.val;
            subAns.remove(subAns.size() - 1);
        }

        if(root.right != null){
            subAns.add(root.val);
            sum += root.val;
            dfs(root.right, ans, subAns, sum, target);
            //回溯回来的时候要移除状态
            sum -= root.val;
            subAns.remove(subAns.size() - 1);
        }
    }

    public static void main(String[] args) {

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