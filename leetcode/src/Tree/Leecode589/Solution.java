package Tree.Leecode589;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> ans = new ArrayList<Integer>();

    public static void main(String[] args) {
        Node n1 = new Node(1);
        List<Node> list1 = new ArrayList<>();
        List<Node> list2 = new ArrayList<>();
        Node n2 = new Node(3);
        Node n3 = new Node(2);
        Node n4 = new Node(4);
        list1.add(n2);
        list1.add(n3);
        list1.add(n4);
        n1.children = list1;

        Node n5 = new Node(5);
        Node n6 = new Node(6);
        list2.add(n5);
        list2.add(n6);

        n2.children = list2;
        n3.children = null;
        n4.children = null;
        n5.children = null;
        n6.children = null;

        List<Integer> res = new Solution().preorder(n1);
        for (Integer re : res) {
            System.out.println(re);
        }
    }
    public List<Integer> preorder(Node root) {
        if(root == null)
            return ans;
        travel(root);
        return ans;
    }

    public void travel(Node root){
        if(root == null)
            return;
        ans.add(root.val);
//        System.out.println(root.val);
        if(root.children != null){
            for (int i = 0; i < root.children.size(); i++) {
                travel(root.children.get(i));
            }
        }
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};