package Graph_Search.Leetcode133.Solution2;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：hodor007
 * @date ：Created in 2020/12/17
 * @description ：
 * @version: 1.0
 */
public class Solution {
    private HashMap<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null){
            return node;
        }
        LinkedList<Node> stack = new LinkedList<>();
        stack.addLast(node);
        Node firstCloneNode = new Node(node.val);
        map.put(node, firstCloneNode);
        while(!stack.isEmpty()){
            Node temp = stack.pollFirst();
            Node cloneNode = map.get(temp);

            for (Node neighbor : temp.neighbors) {
                Node subCloneNode = null;
                if(map.containsKey(neighbor)){
                    subCloneNode = map.get(neighbor);
                    map.put(neighbor, subCloneNode);
                    stack.addLast(neighbor);
                } else {
                    subCloneNode = new Node(neighbor.val);
                    map.put(neighbor, subCloneNode);
                }
                cloneNode.neighbors.add(subCloneNode);
            }
        }
        return map.get(node);
    }

    public static void main(String[] args) {
        Node A = new Node(1);
        Node B = new Node(2);
        Node C = new Node(3);
        Node D = new Node(4);
        A.neighbors.add(B);
        A.neighbors.add(D);
        B.neighbors.add(A);
        B.neighbors.add(C);
        C.neighbors.add(B);
        C.neighbors.add(D);
        D.neighbors.add(A);
        D.neighbors.add(C);

        Solution solution = new Solution();
        Node node = solution.cloneGraph(A);
    }

}


class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}