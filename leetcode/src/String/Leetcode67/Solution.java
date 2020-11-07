package String.Leetcode67;

/**
 * 注意细节，各种情况
 * @author ：hodor007
 * @date ：Created in 2020/11/2
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public String addBinary(String a, String b) {
        char[] _a = a.toCharArray();
        char[] _b = b.toCharArray();
        int aLen = _a.length;
        int bLen = _b.length;
        int carry = 0;
        StringBuilder stringBuilder = new StringBuilder();

        int len = Math.min(_a.length,_b.length);
        //以较短的字符串为标准
        for (int i = 0; i < len; i++) {
            int va = _a[aLen - 1 - i] - 48;
            int vb = _b[bLen - 1 - i] - 48;
            int sum = va + vb + carry;
            if(sum == 0){
                stringBuilder.insert(0,'0');
                carry = 0;
            }else if(sum == 1){
                stringBuilder.insert(0,'1');
                carry = 0;
            }else if(sum == 2){
                stringBuilder.insert(0,'0');
                carry = 1;
            } else if(sum == 3){
                stringBuilder.insert(0,'1');
                carry = 1;
            }
        }

        //如果两字符串长度相等
        if(_a.length == _b.length){
            if(carry == 1){
                stringBuilder.insert(0,'1');
            }
        } else if(_a.length > _b.length){
            //a较长
            for (int i = aLen - bLen - 1; i >= 0; i--) {
                int va = _a[i] - 48;
                int sum = va + carry;
                if(sum == 0){
                    stringBuilder.insert(0,'0');
                    carry = 0;
                } else if(sum == 1){
                    stringBuilder.insert(0,'1');
                    carry = 0;
                } else if(sum == 2){
                    stringBuilder.insert(0,'0');
                    carry = 1;
                }
            }
            //最后还有进位
            if(carry == 1){
                stringBuilder.insert(0,'1');
            }
        } else if(_b.length > _a.length){
            for (int i = bLen - aLen - 1; i >= 0; i--) {
                int vb = _b[i] - 48;
                int sum = vb + carry;
                if(sum == 0){
                    stringBuilder.insert(0,'0');
                    carry = 0;
                } else if(sum == 1){
                    stringBuilder.insert(0,'1');
                    carry = 0;
                } else if(sum == 2){
                    stringBuilder.insert(0,'0');
                    carry = 1;
                }
            }
            //最后还有进位
            if(carry == 1){
                stringBuilder.insert(0,'1');
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        Solution solution = new Solution();
        String ans = solution.addBinary(a, b);
        System.out.println(ans);
    }
}
