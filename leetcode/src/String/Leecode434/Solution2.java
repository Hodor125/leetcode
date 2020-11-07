package String.Leecode434;

public class Solution2 {
    public static void main(String[] args) {
        int i = new Solution2().countSegments("Hello, my name is John");
        System.out.println(i);
    }

    public int countSegments(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ')
                count++;
        }
        return count;
    }
}
