package Stack.Leecode71;

import java.util.Stack;

//存在空串
public class Solution {
    public static void main(String[] args) {
//        Stack<String> stack = new Stack<>();
//        String str = "/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///";
//        String[] strs = str.split("/");
//        for (String s : strs) {
//            System.out.print(s + " ");
//        }
//        for (String s : strs) {
//            stack.push(s);
//        }
//        String ans = String.join("/",stack);
//        System.out.println();
//        System.out.println(ans);
        String str = "/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///";

        String ans = new Solution().simplifyPath(str);
        System.out.println("ans:"+ans);
    }

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        String[] strs = path.split("/");
//        System.out.println("------before------");
//        for (String str : strs) {
//            System.out.print(str);
//        }
//        System.out.println();
        for (String str : strs) {
            if(str.equals("..")){
                if(!stack.isEmpty())
                    stack.pop();
                //还需要去除空格
            } else if(!str.equals(".") && !str.equals("")){
                stack.push(str);
            }
        }
//        System.out.println("-----after-------");
//        for (String s : stack) {
//            System.out.print(s);
//        }
//        System.out.println();
        return "/" + String.join("/",stack);
    }
}
