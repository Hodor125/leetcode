package HashTable.Leetcode146.Solution1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：hodor007
 * @date ：Created in 2020/12/8
 * @description ：
 * @version: 1.0
 */
public class LRUCache {
    //使用了内部类
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
    }

    //快速得到对应位置的节点，传给增删改的函数
    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    //实际的节点数量
    private int size;
    //设定的容量值
    private int capacity;
    //伪头尾节点
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // 如果 key 不存在，创建一个新的节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加至双向链表的头部
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                DLinkedNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        }
        else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value = value;
            moveToHead(node);
        }
    }

    //添加到头部
    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    //移除某个节点
    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    //将某个节点移动到头部
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    //移除尾部节点
    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.get(1);
        lruCache.put(3,3);
        lruCache.travel(lruCache.head);
    }

    //查看缓存中的情况
    private void  travel(DLinkedNode head){
        DLinkedNode p = head;
        while(p != null){
            System.out.print(p.key + ":" + p.value + " ");
            p = p.next;
        }
    }
}
