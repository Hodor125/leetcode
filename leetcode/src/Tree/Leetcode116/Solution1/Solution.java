package Tree.Leetcode116.Solution1;

import java.util.LinkedList;

/**
 * 利用广度优先遍历，使用的也是常数级空间？
 */
public class Solution {
    public Node connect(Node root) {
        if(root == null)
            return root;

        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(root);
        while(queue.size() != 0){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node temp = queue.pollFirst();
                if(i < size - 1){
                    temp.next = queue.peekFirst();
                }
                if(temp.left != null)
                    queue.addLast(temp.left);
                if(temp.right != null)
                    queue.addLast(temp.right);
            }
        }
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};