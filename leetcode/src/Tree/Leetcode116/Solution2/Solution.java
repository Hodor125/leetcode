package Tree.Leetcode116.Solution2;

/**
 * 逐层完成连接
 * 利用了已经连接的next指针
 */
public class Solution {
    public Node connect(Node root) {
        Node leftMost = root;//指向每层的最左边的节点
        while(leftMost != null){
            Node head = leftMost;
            while (head != null){
                if(head.left != null){
                    head.left.next = head.right;
                    if(head.next != null){
                        head.right.next = head.next.left;
                    }
                }
                head = head.next;//当前层的下一个节点
            }
            leftMost = leftMost.left;
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