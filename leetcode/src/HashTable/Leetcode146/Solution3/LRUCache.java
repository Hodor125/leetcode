package HashTable.Leetcode146.Solution3;

import Tree.Leetcode105.Solution2.Solution;

import java.util.HashMap;

/**
 * @author ：hodor007
 * @date ：Created in 2020/12/8
 * @description ：
 * @version: 1.0
 */
public class LRUCache {
    class DLinkNode{
        int key;
        int value;
        DLinkNode pre;
        DLinkNode next;
        DLinkNode() {

        }
        DLinkNode(int _key, int _value){
            this.key = _key;
            this.value = _value;
        }
    }

    //方便快速找到节点
    HashMap<Integer, DLinkNode> map = new HashMap<>();
    //现存的容量
    int size;
    //设定的容量
    int capacity;
    //设定头尾节点
    DLinkNode head;
    DLinkNode tail;

    LRUCache(int _capacity) {
        size = 0;
        this.capacity = _capacity;
        head = new DLinkNode();
        tail = new DLinkNode();
        head.next = tail;
        head.pre = null;
        tail.next = null;
        tail.pre = head;
    }

    public int get(int key) {
        DLinkNode dLinkNode = map.get(key);
        //获取不到返回-1
        if(dLinkNode == null){
            return -1;
        }
        //获取到了将节点移到头部，返回节点值
        moveToHead(dLinkNode);
        return dLinkNode.value;
    }

    public void put(int key, int value) {
        //检查是否存在map中
        DLinkNode dLinkNode = map.get(key);
        if(dLinkNode != null){
            //改值，移动到头部
            dLinkNode.value = value;
            moveToHead(dLinkNode);
            return;
        }
        //如果是新节点，插入链表和map
        dLinkNode = new DLinkNode(key, value);
        addToHead(dLinkNode);
        map.put(key, dLinkNode);
        size++;
        //如果超出了容量
        if(size > capacity){
            int _key = removeTail();
            map.remove(_key);
            size--;
        }
    }

    //移除节点
    private void remove(DLinkNode dLinkNode){
        dLinkNode.pre.next = dLinkNode.next;
        dLinkNode.next.pre = dLinkNode.pre;
    }

    //将节点添加到头节点
    private void addToHead(DLinkNode dLinkNode){
        dLinkNode.pre = head;
        dLinkNode.next = head.next;
        head.next.pre = dLinkNode;
        head.next = dLinkNode;
    }

    //将节点移到头节点
    private void moveToHead(DLinkNode dLinkNode){
        remove(dLinkNode);
        addToHead(dLinkNode);
    }

    private int removeTail(){
        DLinkNode last = tail.pre;
        last.pre.next = tail;
        tail.pre = last.pre;
        return last.key;
    }

//    public static void main(String[] args) {
//        LRUCache lruCache = new LRUCache(2);
//        lruCache.put(1,1);
//        lruCache.put(2,2);
//        lruCache.get(1);
//        lruCache.put(3,3);
//        int val = lruCache.get(2);
//        System.out.println(val);
//        lruCache.travel(lruCache.head);
//    }
//
//    private void travel(DLinkNode dLinkNode){
//        DLinkNode p = dLinkNode;
//        while(p != null){
//            System.out.print(p.key + ":" + p.value + " ");
//            p = p.next;
//        }
//    }
}
