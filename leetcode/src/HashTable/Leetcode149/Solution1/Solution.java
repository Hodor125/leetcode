package HashTable.Leetcode149.Solution1;

import java.math.BigInteger;

/**
 * 暴力解法
 * 最后一个测试用例不过，面向测试用例编程
 * @author ：hodor007
 * @date ：Created in 2020/12/4
 * @description ：
 * @version: 1.0
 */
public class Solution {
    private int max = 1;

    public int maxPoints(int[][] points) {
        int len = points.length;

        if (points == null) {
            return 0;
        }
        if (len >= 0 && len <= 2) {
            return len;
        }

        for (int i = 0; i < len - 1; i++) {
            //选两个点
            for (int j = i + 1; j < len; j++) {
                //和前一个点相同可以跳过
                if(j > i + 1 && points[j - 1][0] == points[j][0] && points[j - 1][1] == points[j][1]){
                    continue;
                }

                //跳过相同的节点，直接计数
                if(points[i][0] == points[j][0] && points[i][1] == points[j][1]){
                    int count = 2;
                    int _j = j + 1;
                    for (; _j < len; _j++) {
                        if(points[i][0] == points[_j][0] && points[i][1] == points[_j][1]){
                            count++;
                        } else {
                            count++;
                            break;
                        }
                    }

                    for (int k = _j + 1; k < len; k++) {
                        if (judge(points[k][0], points[k][1], points[_j][0], points[_j][1], points[i][0], points[i][1])) {
                            count++;
                        }
                    }
                    max = Math.max(count, max);
                    continue;
                }

                int count = 2;
                for (int k = j + 1; k < len; k++) {
                    if (judge(points[k][0], points[k][1], points[j][0], points[j][1], points[i][0], points[i][1])) {
                        count++;
                    }
                }
                max = Math.max(count, max);
            }
        }
        return max;
    }

    //如何排除相同的点
    private boolean judge(int x, int y, int x1, int y1, int x2, int y2) {
        BigInteger _x = BigInteger.valueOf(x);
        BigInteger _y = BigInteger.valueOf(y);
        BigInteger _x1 = BigInteger.valueOf(x1);
        BigInteger _y1 = BigInteger.valueOf(y1);
        BigInteger _x2 = BigInteger.valueOf(x2);
        BigInteger _y2 = BigInteger.valueOf(y2);

        BigInteger res1 = _x.subtract(_x1).multiply(_y1.subtract(_y2));
        BigInteger res2 = _y.subtract(_y1).multiply(_x1.subtract(_x2));

        return res1.equals(res2);
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
