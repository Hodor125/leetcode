package String.Leecode125;

public class Solution2 {
    public static void main(String[] args) {
//        String str = "ABCJS";
//        String str1 = str.substring(0,4);
//        System.out.println(str1);
    }

    public String longestCommonPrefix(String[] strs) {
        int len = Integer.MAX_VALUE;
        for (String str : strs) {
            len = Math.min(len, str.length());
        }
        int left = 0;
        int right = len;
        while(left < right){
            int mid = left + (right - left + 1) / 2;
            if(isCommonPrefix(strs,mid)){
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return strs[0].substring(0,left);
    }

    public boolean isCommonPrefix(String[] strs,int length){
        String str0 = strs[0].substring(0,length);
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i].substring(0,length);
            for (int j = 0; j < length; j++) {
                if(str.charAt(j) != str0.charAt(j))
                    return false;
            }
        }
        return true;
    }
}
