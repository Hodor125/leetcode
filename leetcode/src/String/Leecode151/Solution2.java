package String.Leecode151;

import Array.Leecode495.Solution;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2 {
    public static void main(String[] args) {
        String str = "the sky is blue";
        String s = new Solution2().reverseWords(str);
        System.out.println(s);
    }

    public String reverseWords(String s) {
        if(s == null || s.length() == 0)
            return s;

        int l = 0;
        int r = s.length() - 1;
        while(l <= r && s.charAt(l) == ' ')
            l++;
        while(l <= r && s.charAt(r) == ' ')
            r--;
        ArrayDeque<String> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        while(l <= r){
            if(sb.length() != 0 && s.charAt(l) == ' '){
                queue.offerFirst(sb.toString());
                sb.setLength(0);
            } else if(s.charAt(l) != ' '){
                sb.append(s.charAt(l));
            }
            l++;
        }
        queue.offerFirst(sb.toString());
        return String.join(" ",queue);
    }
}
