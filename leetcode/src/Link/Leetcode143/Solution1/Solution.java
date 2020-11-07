package Link.Leetcode143.Solution1;

import java.util.ArrayList;

/**
 * 利用有序的ArrayList存储
 * 可以方便地获取节点进行操作
 */
public class Solution {
      public void reorderList(ListNode head) {
            //链表为空和长度为1和长度为2的情况直接返回
            if(head == null || head.next == null || head.next.next == null)
                  return;

            ArrayList<ListNode> listNodes = new ArrayList<>();
            ListNode p = head;
            while(p != null){
                  listNodes.add(p);
                  p = p.next;
            }

            int r = listNodes.size() - 1;
            int l = 0;
            while(l <= r){
                  //长度为奇数时的结尾情况
                  if(l == r){
                        listNodes.get(l).next = null;
                        break;
                  }

                  listNodes.get(l).next = listNodes.get(r);
                  listNodes.get(r).next = listNodes.get(l + 1);

                  //长度为偶数时的结尾情况
                  if(r - 1 == l){
                        listNodes.get(r).next = null;
                        break;
                  }
                  l++;
                  r--;
            }
      }

      public static void main(String[] args) {
            ListNode l1 = new ListNode(1);
            ListNode l2 = new ListNode(2);
            ListNode l3 = new ListNode(3);
            ListNode l4 = new ListNode(4);
            ListNode l5 = new ListNode(5);
            l1.next = l2;
            l2.next = l3;
            l3.next = l4;
            l4.next = l5;
            l5.next = null;

            Solution solution = new Solution();
            solution.reorderList(l1);

            ListNode p = l1;
            while(p != null){
                  System.out.println(p.val + " ");
                  p = p.next;
            }
      }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}