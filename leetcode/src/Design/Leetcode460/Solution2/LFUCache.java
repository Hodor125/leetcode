package Design.Leetcode460.Solution2;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author ：hodor007
 * @date ：Created in 2021/3/24
 * @description ：
 * @version: 1.0
 */
public class LFUCache {
    int capacity, time;
    Map<Integer, Node> table;
    TreeSet<Node> S;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.time = 0;
        table = new HashMap<>();
        S = new TreeSet<>();
    }

    public int get(int key) {
        if(capacity == 0)
            return -1;
        if(!table.containsKey(key))
            return -1;

        Node node = table.get(key);
        S.remove(node);
        node.cnt += 1;
        node.time = ++time;

        table.put(key, node);
        S.add(node);
        return node.value;
    }

    public void put(int key, int value) {
        if(capacity == 0)
            return;

        if(table.containsKey(key)) {
            Node node = table.get(key);

            S.remove(node);
            node.time = ++time;
            node.cnt += 1;
            node.value = value;

            S.add(node);
            table.put(key, node);
        } else {
            //容量满了
            if(this.capacity == table.size()) {
                table.remove(S.first().key);
                S.remove(S.first());
            }

            Node node = new Node(key, value, 1, ++time);
            S.add(node);
            table.put(key, node);
        }
    }

    public static void main(String[] args) {
        LFUCache solution = new LFUCache(2);
        solution.put(1,1);
        solution.put(2,2);
        int i = solution.get(2);
        System.out.println(i);
        solution.put(3,3);
        int i1 = solution.get(1);
        System.out.println(i1);
    }
}

class Node implements Comparable<Node> {
    int key, value, cnt, time;

    public Node(int key, int value, int cnt, int time) {
        this.key = key;
        this.value = value;
        this.cnt = cnt;
        this.time = time;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj instanceof Node) {
            Node node = (Node) obj;
            return this.cnt == node.cnt && this.time == node.time;
        }

        return super.equals(obj);
    }

    @Override
    public int compareTo(Node o) {
        return this.cnt == o.cnt ? this.time - o.time : this.cnt - o.cnt;
    }

    @Override
    public int hashCode() {
        return this.cnt * 17 + time;
    }
}
