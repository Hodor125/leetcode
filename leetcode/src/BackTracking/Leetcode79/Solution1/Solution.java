package BackTracking.Leetcode79.Solution1;

/**
 * 需要用一个矩阵标记是否访问过
 *
 * @author ：hodor007
 * @date ：Created in 2020/11/8
 * @description ：
 * @version: 1.0
 */
public class Solution {
    private char[][] board = null;
    private String word = null;
    private int[][] direct = null;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        //上右下左
        int[][] _direct = {
                {-1,0},
                {0,1},
                {1,0},
                {0,-1}
        };
        this.direct = _direct;
        int rows = board.length;
        int columns = board[0].length;
        //特判
        if(board == null || columns == 0 || columns == 0){
            return false;
        }
        //判断是否访问过
        boolean[][] mark = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(dfs(mark,i,j,0))
                    return true;
            }
        }
        return false;
    }

    /**
     * @param x     当前坐标
     * @param y     当前坐标
     * @param count 走过的路径
     * @return
     */
    private boolean dfs(boolean[][] mark, int x, int y, int count) {
        //设置循环结束条件
        if (count == word.length() - 1) {
            return board[x][y] == word.charAt(count);
        }

        //遍历如果当前的字母和字符串的字母相等，则向四个方向拓展
        if(board[x][y] == word.charAt(count)){
            mark[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int newX = x + direct[i][0];
                int newY = y + direct[i][1];
                //下一个方向不越界且未访问过
                if(inMatrix(newX,newY) && !mark[newX][newY]){
                    //终止循环
                    if(dfs(mark,newX,newY,count + 1))
                        return true;
                }
            }
            //回溯
            mark[x][y] = false;
        }
        return false;
    }

    /**
     * 判断是否越界
     * @param x
     * @param y
     * @return
     */
    boolean inMatrix(int x,int y){
        int rows = board.length;
        int columns = board[0].length;
        if(x >= 0 && x <= rows - 1 && y >=0 && y <= columns - 1){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
//        char[][] matrix = {
//                {'A','B','C','E'},
//                {'S','F','C','S'},
//                {'A','D','E','E'}
//        };

        char[][] matrix = {
                {'A','B','C','E'},
        };
        Solution solution = new Solution();
        boolean ans = solution.exist(matrix, "ABCE");
        System.out.println(ans);
    }
}
