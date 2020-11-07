package Link;

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

/*
第一遍复制节点的 val ，next 和 random暂时为空，并将源节点和克隆节点形成映射存放在一个 HashMap中

第二遍新链表的next和random节点

时间复杂度O(n)
空间复杂度O(n)

!!!解决方法:纸上画图分析
 */

import javax.xml.soap.Node;
import java.util.HashMap;

public class Leecode138 {
    public static void main(String[] args) {
        Node138 n1 = new Node138(7);
        Node138 n2 = new Node138(13);
        Node138 n3 = new Node138(11);
        Node138 n4 = new Node138(10);
        Node138 n5 = new Node138(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;

        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n1;

        Node138 node = Leecode138.copyRandomList2(n1);

//        Leecode138.print(n1);
        Node138 p = node;
        while(p != null){
            System.out.print("[" + p.val + ",");
            if(p.random != null)
                System.out.println(p.random.val + "]");
            else
                System.out.println("null]");
            p = p.next;
        }

    }

    public static Node138 copyRandomList(Node138 head) {
        HashMap<Node138, Node138> map = new HashMap<>();
        Node138 p = head;
        while(p != null){
            map.put(p, new Node138(p.val));
            p = p.next;
        }

        p = head;
        while(p != null){
            map.get(p).next = map.get(p.next);
            map.get(p).random = map.get(p.random);
            p = p.next;
//            System.out.println(map.get(p).val + "->" + map.get(p.next).val);
        }
        return map.get(head);
    }

    //类比有有丝分裂
    //写循环很容易忘记节点指向下一节点
    public static Node138 copyRandomList2(Node138 head) {
        Node138 p = head;

        if(head == null)
            return null;
        //复制一样的节点分在原节点后面
        while(p != null){
            Node138 temp = p.next;
            Node138 newNode = new Node138(p.val);
            p.next = newNode;
            newNode.next = temp;
            p = p.next.next;

//            Node138 temp = new Node138(p.val);
//            temp.next = p.next;
//            p.next = temp;
//            p = p.next.next;
        }

        //复制新节点的random，由于复制了相同的节点，所以是偶数，不用担心没有p.next.next
        p = head;
        while(p != null){
            if(p.random != null){
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }

        //两条链表拆分
        p = head;
        Node138 cloneP = head.next;
        Node138 cloneHead = cloneP;
        while(cloneP.next != null){
            p.next = p.next.next;
            p = p.next;
            cloneP.next = cloneP.next.next;
            cloneP = cloneP.next;
        }

        p.next = null;
        return cloneHead;
    }

    //输出链表
    public static void print(Node138 p){
        while(p != null){
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.println("null");
    }
}

class Node138 {
    int val;
    Node138 next;
    Node138 random;

    public Node138(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
