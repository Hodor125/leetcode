package Graph_Search.Leecode1162;

import java.util.ArrayDeque;
import java.util.Queue;

/*
可用BFS，类似Leecode102BFS解法
要解最短路径问题，我们首先要写出层序遍历的代码，仿照上面的二叉树层序遍历代码，类似地可以写出网格层序遍历
 */
public class Solution {
    public static int maxDistance(int[][] grid) {
        Queue<int[]> que = new ArrayDeque<int[]>();

        int N = grid.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1)
                    que.add(new int[]{i, j});
            }
        }

        if (que.isEmpty() || que.size() == N * N)
            return -1;

        int dist = -1;//记录当前遍历层数
        while (!que.isEmpty()) {
            dist++;
            int levelnum = que.size();
            for (int i = 0; i < levelnum; i++) {
                int[] temp = que.poll();

                int x = temp[0];
                int y = temp[1];

                if (x > 0 && grid[x - 1][y] == 0) {
                    que.add(new int[]{x - 1, y});
                    grid[x - 1][y] = 2;
                }

                if (x + 1 < N && grid[x + 1][y] == 0) {
                    que.add(new int[]{x + 1, y});
                    grid[x + 1][y] = 2;
                }

                if (y > 0 && grid[x][y - 1] == 0) {
                    que.add(new int[]{x, y - 1});
                    grid[x][y - 1] = 2;
                }

                if (y + 1 < N && grid[x][y + 1] == 0) {
                    que.add(new int[]{x, y + 1});
                    grid[x][y + 1] = 2;
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int[][] map = {{1, 0, 0, 0, 0, 1, 0, 0, 0, 1}, {1, 1, 0, 1, 1, 1, 0, 1, 1, 0}, {0, 1, 1, 0, 1, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 1, 1, 0, 1, 1}, {0, 0, 1, 0, 0, 1, 0, 1, 0, 1},
                {0, 0, 0, 1, 1, 1, 1, 0, 0, 1}, {0, 1, 0, 0, 1, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 1, 1, 1, 0, 0},
                {1, 1, 0, 1, 1, 1, 1, 1, 0, 0}};

        int[][] map2 = {{1, 0, 0},
                {0, 0, 0},
                {0, 0, 0}};
        System.out.println(maxDistance(map));
    }
}
