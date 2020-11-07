package Tree.Leecode145;

import java.util.ArrayDeque;

public class Test {
    public static void main(String[] args) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(2);
        stack.push(1);
        stack.push(3);
        stack.push(4);
        //翻译的文档有错误?
        System.out.println(stack.peek());
    }
}
