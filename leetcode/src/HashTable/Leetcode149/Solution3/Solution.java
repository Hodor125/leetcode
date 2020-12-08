package HashTable.Leetcode149.Solution3;

/**
 * @author ：hodor007
 * @date ：Created in 2020/12/6
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public int maxPoints(int[][] points) {
        int len = points.length;
        if(len <= 2){
            return len;
        }

        //只要第一个点和其他点的组合就够了
        int i = 0;
        for (; i < len; i++) {
            if(i < len - 1 && (points[i][0] != points[i + 1 ][0] || points[i][1] != points[i + 1][1])){
                break;
            }
        }
        if(i == len){
            return len;
        }

        int max = 0;
        for (i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                //选择两个点，跳过相同的点
                if(points[i][0] == points[j][0] && points[i][1] == points[j][1]){
                    continue;
                }

                int maxTemp = 0;
                for (int k = 0; k < len; k++) {
                    if(k == i || k == j){
                        continue;
                    }

                    if(judge(points[i][0],points[i][1],points[j][0],points[j][1],points[k][0],points[k][1])){
                        maxTemp++;
                    }
                }
                if(maxTemp > max){
                    max = maxTemp;
                }
            }
        }

        return max + 2;
    }

    private boolean judge(int x1, int y1, int x2, int y2, int x, int y){
        int gcd1 = gcd(y2 - y1, x2 - x1);
        if(x == x2 && y == y2){
            return true;
        }
        int gcd2 = gcd(y2 - y, x2 - x);
        return (y2 - y1) / gcd1 == (y2 - y) / gcd2 && (x2 - x1) / gcd1 == (x2 - x) / gcd2;
    }

    //辗转相除法求最大公约数
    private int gcd(int a, int b){
        while(b != 0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        int[][] points = {
                {1,1},
                {1,1},
                {0,0},
                {3,4},
                {4,5},
                {5,6},
                {7,8},
                {8,9}
        };
        Solution solution = new Solution();
        int ans = solution.maxPoints(points);
        System.out.println(ans);
    }
}
