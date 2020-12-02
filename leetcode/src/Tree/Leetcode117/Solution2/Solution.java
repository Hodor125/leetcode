package Tree.Leetcode117.Solution2;

import com.sun.jmx.snmp.SnmpNull;

import javax.swing.tree.TreeNode;

/**
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

        Node p = root;
        Node head = null;
        Node listP = null;

        while(p != null){
            while(p != null){
                //找到链表的头节点
                if(p.left != null){
                    head = p.left;
                    break;
                }
                if(p.right != null){
                    head = p.right;
                    break;
                }
                p = p.next;
            }

            if(p == null){
                break;
            }
            //将本节点处理完毕
            listP = head;
            if(head == p.left){
                if(p.right != null){
                    listP.next = p.right;
                    listP = p.right;
                }
            }
            //处理剩余的节点
            p = p.next;
            while(p != null){
                if(p.left != null){
                    listP.next = p.left;
                    listP = p.left;
                }
                if(p.right != null){
                    listP.next = p.right;
                    listP = p.right;
                }
                p = p.next;
            }
            listP.next = null;
            //下一行
            p = head;
        }
        return root;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n7 = new Node(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = null;
        n3.right = n7;
        n4.left = null;
        n4.right = null;
        n5.left = null;
        n5.right = null;
        n7.left = null;
        n7.right = null;
        Solution solution = new Solution();
        solution.connect(n1);
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