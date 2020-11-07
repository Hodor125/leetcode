package Graph_Search.Leecode51.mySolution;

import java.util.*;

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ansList = new ArrayList<>();
        Set<Integer> rows = new HashSet<>();//行检测
        Set<Integer> diagonal1 = new HashSet<>();//对角线检测
        Set<Integer> diagonal2 = new HashSet<>();
        int[] position = new int[n];//在每行填入的位置，生成答案的时候使用

        dfs(ansList,n,0,position,rows,diagonal1,diagonal2);
        return ansList;
    }

    /**
     *
     * @param ansList 答案
     * @param row 总行数
     * @param curr_column 当前行
     * @param rows 行检测
     * @param diagonal1 对角线检测
     * @param diagonal2 对角线检测
     */
    public void dfs(List<List<String>> ansList,int row,int curr_column,int[] position,Set<Integer> rows,Set<Integer> diagonal1,Set<Integer> diagonal2){
        //已经填完了
        if(row == curr_column){
            List<String> subAns = generate(position);
            ansList.add(subAns);
            return;
        }

        for (int i = 0; i < row; i++) {
            //判断这行的这个位置是否合法
            if(rows.contains(i))
                continue;

            int diagonal_1 = curr_column - i;
            if(diagonal1.contains(diagonal_1))
                continue;

            int diagonal_2 = curr_column + i;
            if(diagonal2.contains(diagonal_2))
                continue;

            //合法则修改
            rows.add(i);
            diagonal1.add(diagonal_1);
            diagonal2.add(diagonal_2);
            position[curr_column] = i;//当前行填入Q的位置

            //进入分支
            dfs(ansList,row,curr_column + 1,position,rows,diagonal1,diagonal2);

            //失败则修改回来
            position[curr_column] = -1;
            rows.remove(i);
            diagonal1.remove(diagonal_1);
            diagonal2.remove(diagonal_2);

        }
    }

    public List<String> generate(int[] position){
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            char[] row = new char[position.length];
            Arrays.fill(row,'.');
            row[position[i]] = 'Q';
            ans.add(new String(row));
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> lists = solution.solveNQueens(8);
        int count= 0;
        if(lists != null){
            for (List<String> list : lists) {
                count++;
                for (String s : list) {
                    System.out.println(s);
                }
                System.out.println("-------------");
            }
        } else {
            System.out.println("null");
        }
        System.out.println("total:" + count);
    }

}
