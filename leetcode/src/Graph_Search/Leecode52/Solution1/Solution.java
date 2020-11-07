package Graph_Search.Leecode52.Solution1;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 三刷
 */
public class Solution {
    public int totalNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();    //存放答案集合
        boolean[][] pos = new boolean[n][n];    //是否放皇后
        //定义辅助变量
        boolean[] columns = new boolean[n];    //检验列是否重复
        HashSet<Integer> diagonal1 = new HashSet<>();//斜线：左下到右上
        HashSet<Integer> diagonal2 = new HashSet<>();    //斜线：右上到左下
        dfs(ans,pos,0,n,columns,diagonal1,diagonal2);

//        for (List<String> an : ans) {
//            for (String s : an) {
//                System.out.println(s);
//            }
//            System.out.println("++++++++++++++++++++++++++++++++++++++");
//        }

        return ans.size();
    }

    /*
    每行的而每个位置进行尝试
    行和列是相等的
    没必要设置行检测，因为行递增，当前行填过了就不会再填了
     */

    /**
     *
     * @param ans 存放的可视化结果集
     * @param pos 存放的结果集
     * @param curr_row 当前行
     * @param row 总行数
     * @param columns 列检测
     * @param diagonal1 对角线检测1：从左下方到右上方，使用下标加法
     * @param diagonal2 对角线检测2：从右上方到左下方，使用下标减法
     */
    public void dfs(List<List<String>> ans,boolean[][] pos,int curr_row,int row,boolean[] columns,
                    HashSet<Integer> diagonal1,HashSet<Integer> diagonal2){
        //循环终止条件,已经填完了,因为下标是从0开始的
        if(curr_row == row){
            getSubAns(ans,pos);
            return;
        }

        for (int i = 0; i < row; i++) {
            //如果位置合法就填入，如果位置不合法就跳过
            if(columns[i])
                continue;

            //计算对角线
            int d1 = curr_row + i;
            if(diagonal1.contains(d1))
                continue;

            int d2 = curr_row - i;
            if(diagonal2.contains(d2))
                continue;

            //如果位置合法，填入数字，修改辅助变量
            pos[curr_row][i] = true;
            columns[i] = true;
            diagonal1.add(d1);
            diagonal2.add(d2);
            dfs(ans,pos,curr_row + 1,row,columns,diagonal1,diagonal2);

            //回溯回来要将变量改回去
            pos[curr_row][i] = false;
            columns[i] = false;
            diagonal1.remove(d1);
            diagonal2.remove(d2);
        }
    }

    private void getSubAns(List<List<String>> ans,boolean[][] pos){
        int len = pos.length;
        char[][] subAns = new char[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if(pos[i][j] == false)
                    subAns[i][j] = '.';
                else
                    subAns[i][j] = 'Q';
            }
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            //String导错包了，无语
            list.add(new String(subAns[i]));
        }
        ans.add(list);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int ans = solution.totalNQueens(8);
        System.out.println(ans);
    }
}
