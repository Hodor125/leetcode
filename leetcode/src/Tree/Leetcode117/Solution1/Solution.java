package Tree.Leetcode117.Solution1;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS实现
 * @author ：hodor007
 * @date ：Created in 2020/12/2
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public Node connect(Node root) {
        if(root == null){
            return root;
        }

        LinkedList<Node> queue = new LinkedList<>();
        queue.addFirst(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            Node pre = null;
            for (int i = 0; i < size; i++) {
                Node node = queue.pollLast();
                if(node.right != null){
                    queue.addFirst(node.right);
                    node.right.next = pre;
                    pre = node.right;
                }
                if(node.left != null){
                    queue.addFirst(node.left);
                    node.left.next = pre;
                    pre = node.left;
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
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