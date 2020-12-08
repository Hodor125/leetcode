package Link.Leetcode147.Solution2;

/**
 * @author ：hodor007
 * @date ：Created in 2020/12/7
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null){
            return head;
        }

        ListNode dummyHead = new ListNode(Integer.MAX_VALUE);
        dummyHead.next = head;
        ListNode lastSorted = head;
        ListNode cur = head.next;
        while(cur != null){
            ListNode p = head;
            ListNode pre = dummyHead;
            while(p != lastSorted.next){
                //小于头节点
                if(p == head && p.val >= cur.val){
                    //指针lastSorted 不变
                    lastSorted.next = cur.next;
                    cur.next = dummyHead.next;
                    dummyHead.next = cur;
                    //更新局部首部节点
                    head = cur;
                    //继续向后排序!!!!!
//                    cur = lastSorted.next;
                    break;
                }

                if(cur.val <= p.val){
                    lastSorted.next = cur.next;
                    cur.next = p;
                    pre.next = cur;
                    break;
                }

                //大于lastSorted
                if(p == lastSorted && cur.val > p.val){
                    //直接将lastSorted后移
                    lastSorted = lastSorted.next;
                    break;
                }

                p = p.next;
                pre = pre.next;
            }
            cur = lastSorted.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(0);
        ListNode l5 = new ListNode(0);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = null;
        Solution solution = new Solution();
        ListNode head = solution.insertionSortList(l1);
        ListNode p = head;
        while(p != null){
            System.out.print(p.val + " ");
            p = p.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}