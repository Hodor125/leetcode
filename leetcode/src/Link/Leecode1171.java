package Link;

import java.util.HashMap;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

/*
HashMap 两次遍历即可
首次遍历建立 节点处链表和<->节点 哈希表
若同一和出现多次会覆盖，即记录该sum出现的最后一次节点

第二遍遍历 若当前节点处sum在下一处出现了则表明两结点之间所有节点和为0 直接删除区间所有节点
 */

public class Leecode1171 {
    public static void main(String[] args) {
        ListNode1171 l1 = new ListNode1171(1);
        ListNode1171 l2 = new ListNode1171(2);
        ListNode1171 l3 = new ListNode1171(-3);
        ListNode1171 l4 = new ListNode1171(3);
        ListNode1171 l5 = new ListNode1171(1);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = null;

//        Leecode1171.print(l1);

        ListNode1171 node = Leecode1171.removeZeroSumSublists2(l1);
        Leecode1171.print(node);
    }

    //容易忘记指针后移,遍历节点
    public static void print(ListNode1171 node){
        ListNode1171 p = node;
        while(p != null){
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.println("null");
    }

    public static ListNode1171 removeZeroSumSublists(ListNode1171 head) {
        HashMap<Integer, ListNode1171> map = new HashMap<>();
        ListNode1171 node = new ListNode1171(0);
        node.next = head;
        int sum = 0;
        //第一次遍历
        for(ListNode1171 p = node; p != null; p = p.next){
            sum += p.val;
            map.put(sum, p);
        }

//        for (Integer integer : map.keySet()) {
//            System.out.println(integer + ":" + map.get(integer).val);
//        }

//        print(node);

        //第二次遍历
        sum = 0;
        for(ListNode1171 p = node; p != null; p = p.next){
            sum +=p.val;
            if(map.containsKey(sum))
                p.next = map.get(sum).next;
//            System.out.println("val:" + p.val);
        }
        return node.next;
    }

    public static ListNode1171 removeZeroSumSublists2(ListNode1171 head){
        if(head.next == null)
            if(head == null)
                return null;
            else if(head.val == 0)
                return null;

        ListNode1171 node = new ListNode1171(0);
        node.next = head;
        ListNode1171 h = node;

        while(h.next != null){
            ListNode1171 p = h.next;
            ListNode1171 q = p.next;
            int sum = p.val;
            //计算p到q之间的和
            while(q != null){
                sum += q.val;
                if(sum ==0){
                    h.next = q.next;
                    break;
                }else
                    q = q.next;
            }
            if(sum != 0)
                h = h.next;
        }
        return node.next;
    }
}

class ListNode1171 {
    int val;
    ListNode1171 next;

    ListNode1171(int x) {
        val = x;
    }
}