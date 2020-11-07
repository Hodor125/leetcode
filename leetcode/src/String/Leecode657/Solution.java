package String.Leecode657;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String str = "UUUDDDLLRRD";
        boolean flag = judgeCircle(str);
        System.out.println(flag);
    }

    //变量存储
    public static boolean judgeCircle(String moves) {
        char[] action = moves.toCharArray();
        int level = 0;
        int vertical = 0;
        for (char c : action) {
            if(c == 'U')
                vertical++;
            else if(c == 'D')
                vertical--;
            else if(c == 'L')
                level++;
            else if(c == 'R')
                level--;
        }
        if(level != 0 || vertical != 0)
            return false;
        return true;
    }


}
