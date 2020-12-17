package Graph_Search.Leetcode133.Solution1;

import java.util.ArrayList;
import java.util.HashMap;
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
        if(map.containsKey(node)){
            return map.get(node);
        }
        //复制节点
        Node cloneNode = new Node(node.val);
        map.put(node, cloneNode);
        //复制邻居节点
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
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