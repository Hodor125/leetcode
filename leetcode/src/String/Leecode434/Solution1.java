package String.Leecode434;

public class Solution1 {
    public static void main(String[] args) {
        String str = "            ";
        int i = new Solution1().countSegments(str);
        System.out.println(i);
    }

    public int countSegments(String s) {
        s = s.trim();
        String[] arr = s.split("\\s+");
        return arr.length;
    }
}
