package dfs.Leecode547;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        int[][] map = {
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };
        System.out.println(findCircleNum2(map));

    }

    //DFS
    public static int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;

        for (int i = 0; i < M.length; i++) {
            if(visited[i] == 0){
                dfs(M,i,visited);
                count++;
            }
        }
        return count;
    }

    public static void dfs(int[][] M,int i,int[] visited){
        visited[i] = 1;
        for (int j = 0; j < M.length; j++) {
            if(M[i][j] == 1 && visited[j] == 0){
                dfs(M,j,visited);
            }
        }
    }

    //BFS
    public static int findCircleNum2(int[][] M){
        int[] visited = new int[M.length];

        int count = 0;

        for (int i = 0; i < M.length; i++) {
            Queue<Integer> queue = new LinkedList<>();
            if(visited[i] == 0){
                queue.add(i);
                count++;
            }

            while(!queue.isEmpty()){
                int s = queue.remove();
                visited[s] = 1;
                for (int j = 0; j < M.length; j++) {
                    if(M[s][j] == 1 && visited[j] == 0)
                        queue.add(j);
                }
            }

        }
        return count;
    }
}
