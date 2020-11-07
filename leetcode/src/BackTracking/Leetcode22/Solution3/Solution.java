package BackTracking.Leetcode22.Solution3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 如何使用bfs遍历,借助栈吧
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        ArrayDeque<Node> queue = new ArrayDeque<>();

        queue.addLast(new Node("",n,n));
        bfs(ans,queue,n,n);
        return ans;
    }

    //当右括号的剩余数量大于左括号剩余数量时肯定时错误答案，这个分支可以去除
    public void bfs(List<String> ans,ArrayDeque<Node> queue,int left,int right){
        //栈不空就循环
        while(queue.size() != 0){
            Node temp = queue.pop();
            //得到答案
            if(temp.left == 0 && temp.right == 0){
                ans.add(temp.subAns);
            }

            //进入左分支，带剪枝
            if(temp.left > 0 && temp.left - 1 <= temp.right){
                queue.addLast(new Node(temp.subAns + "(",temp.left - 1,temp.right));
            }

            //进入右分支，带剪枝
            if(temp.right > 0 && temp.left <= temp.right - 1){
                queue.addLast(new Node(temp.subAns + ")", temp.left, temp.right - 1));
            }
        }
    }

    public static void main(String[] args) {
        //ArrayDeque如何运作,pop弹出第一个节点，push在第一个节点前面加节点，addLast在最后加节点
        int num = 3;
        Solution solution = new Solution();
        List<String> strings = solution.generateParenthesis(num);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}

class Node{
    String subAns;//当前的字串
    int left;//左括号剩余
    int right;//右括号剩余

    public Node(String subAns, int left, int right) {
        this.subAns = subAns;
        this.left = left;
        this.right = right;
    }
}