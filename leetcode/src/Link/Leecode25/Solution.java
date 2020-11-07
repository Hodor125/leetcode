package Link.Leecode25;

public class Solution {
    //不要怂，推导第二次循环再修改完善条件
    //先定义整体的思路，使用四个指针迭代
    public ListNode reverseKGroup(ListNode head, int k) {
        //特判
        if(head == null || k == 1)
            return head;

        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode tail = newHead;
        ListNode prep = null;
        ListNode nextN = newHead;

        while(true){
            //刚好整除，没有剩余，结束循环
            if(nextN == null)
                break;

            prep = tail;
            head = tail.next;

            boolean flag = true;
            for (int i = 0; i < k; i++) {
                if(tail.next != null)
                    tail = tail.next;
                else{
                    flag = false;
                    break;
                }
            }

            //判断数量是否够一个分组,够的情况下标记下一个分组的开头节点nextN，不够一个分组就停止循环
            if(!flag)
                break;
            else{
                nextN = tail.next;
            }

            //进行分组内的交换
            ListNode p = head;
            ListNode q = p.next;
            while(q != nextN){
                ListNode t = q.next;
                q.next = p;
                p = q;
                q = t;
            }

            //新分组的头尾节点处理
            prep.next = tail;
            head.next = nextN;

            //tail和head交换过来
            ListNode t = tail;
            tail = head;
            head = t;
        }
        return newHead.next;
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
        ListNode ans = solution.reverseKGroup(l1,2);

        ListNode p = ans;
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