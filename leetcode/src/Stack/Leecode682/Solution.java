package Stack.Leecode682;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        String[] arr = {"5","2","C","D","+"};
        int ans = new Solution().calPoints(arr);
        System.out.println(ans);
    }

    public int calPoints(String[] ops) {
        int sum = 0;
        Stack<Integer> stack = new Stack<Integer>();

        for (String op : ops) {
            if(op.equals("C")){
                int popNum = stack.pop();
                sum -= popNum;
            }else if(op.equals("D")){
                int num = stack.peek();
                stack.push(num * 2);
                sum += num * 2;
            }else if(op.equals("+")){
                int num = stack.pop();
                int newTop = num + stack.peek();
                stack.push(num);
                stack.push(newTop);
                sum += newTop;
            }else{
                stack.push(Integer.parseInt(op));
                sum += Integer.parseInt(op);
            }
        }
        return sum;
    }
}
