package Graph_Search.Leecode52;

import java.util.*;

/*
二刷
 */
public class Solution {
    private int count = 0;
    public int totalNQueens(int n) {
        //定义辅助变量
        Set<Integer> columns = new HashSet<>();//行检测
        Set<Integer> diagonal1 = new HashSet<>();//对角线检测，同一条对角线当前行左边减去列坐标或者加上列坐标是相等的
        Set<Integer> diagonal2 = new HashSet<>();//对角线检测
        int[] position = new int[n];//答案，存储每一行填入的位置
//        List<List<String>> ansList = new ArrayList<>();//所有答案

        dfs(position,n,0,columns,diagonal1,diagonal2);

        return count;
    }

    /**
     *
     * @param position 子答案数组，存放每一行放Q的位置，用于生成答案
     * @param row 总行数
     * @param curr_row 当前要填写的行
     * @param columns 列冲突检测
     * @param diagonal1 对角线冲突检测
     * @param diagonal2 对角线冲突检测
     */
    public void dfs(int[] position,int row,int curr_row,Set<Integer> columns,
                    Set<Integer> diagonal1,Set<Integer> diagonal2){
        //全部行都填写了
        if(curr_row == row){
//            List<String> subAns = generate(position);
//            ansList.add(subAns);
            count++;
            return;//回溯其他答案
        }

        //对每一行进行回溯,列数和行数相等
        for (int i = 0; i < row; i++) {
            //相同的列有皇后了就跳过这个位置
            if(columns.contains(i))
                continue;

            //当前行减去列坐标得到归属于哪一条斜线，检测这条斜线是否冲突（同一条斜线行坐标减去列坐标相等）
            int diagonal_1 = curr_row - i;
            if(diagonal1.contains(diagonal_1))
                continue;

            //当前行加上列坐标得到归属的另一条斜线
            int diagonal_2 = curr_row + i;
            if(diagonal2.contains(diagonal_2))
                continue;

            //当前位置是合法的，修改相关辅助变量，填入数字
            columns.add(i);
            diagonal1.add(diagonal_1);
            diagonal2.add(diagonal_2);
            position[curr_row] = i;

            //进入分支，填下一行
            dfs(position,row,curr_row + 1,columns,diagonal1,diagonal2);

            //回溯回来，这条分支没有正确答案或者全部填写完成了，删除辅助变量的相关值和本次填入的位置（改为-1）
            columns.remove(i);
            diagonal1.remove(diagonal_1);
            diagonal2.remove(diagonal_2);
            position[curr_row] = -1;
        }
    }

    //根据每一行填入的位置生成答案
    public List<String> generate(int[] position){
        List<String> subAns = new ArrayList<>();

        for (int i = 0; i < position.length; i++) {
            char[] row = new char[position.length];
            Arrays.fill(row,'.');
            row[position[i]] = 'Q';
            subAns.add(new String(row));
        }
        return subAns;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        //测试generate函数
//        int[] position = {2,1,0,3,4};
//        List<String> generate = solution.generate(position);
//        for (String s : generate) {
//            System.out.println(s);
//        }

        int ans = solution.totalNQueens(8);

        System.out.println(ans);


    }
}
