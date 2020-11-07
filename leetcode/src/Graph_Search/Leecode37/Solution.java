package Graph_Search.Leecode37;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    //是否已经填充
    private boolean[][] rows = new boolean[9][9];
    private boolean[][] columns = new boolean[9][9];
    private boolean[][][] boxes = new boolean[3][3][9];
    private List<int[]> space = new ArrayList<>();
    boolean valid = false;

    //初始化
    public void solveSudoku(char[][] board) {
        int len = board.length;
        int wid = board[0].length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < wid; j++) {
                int num = board[i][j] - '0' - 1;
                if('.' == board[i][j]){
                    space.add(new int[]{i, j});
                }else{
                    rows[i][num] = true;
                    columns[j][num] = true;
                    boxes[i / 3][j / 3][num] = true;
                }
            }
        }
        dfs(board,0);
    }

    public void dfs(char[][] board,int start){
        if(start == space.size()){
            valid = true;
            return;
        }

        int[] pos = space.get(start);
        int x = pos[0];
        int y = pos[1];

        //这个!valid很重要，当已经完成了正确答案返回到这里的时候就终止循环不要再瞎改了
        // 否则还是会继续把当前的位置改为其他数字
        /*
        递归终止的条件并不是只有valid=true这一个
         */
        for (int i = 0; i < 9 && !valid; i++) {
            //尝试填入数字
            if(!rows[x][i] && !columns[y][i] && !boxes[x / 3][y / 3][i]){
                rows[x][i] = true;
                columns[y][i] = true;
                boxes[x / 3][y / 3][i] = true;
                board[x][y] = (char) ('0' + i + 1);
                dfs(board,start + 1);
                //如果没有改回来就可以看到最后的结果了，所以必须及时刹车加上!valid
                //恢复成'.'最后的结果就是原数组了，答案不会保留
//                board[x][y] = '.';
                rows[x][i] = false;
                columns[y][i] = false;
                boxes[x / 3][y / 3][i] = false;
            }
        }
    }

    public void print(){
        for (boolean[] row : rows) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("-----------");

        for (boolean[] column : columns) {
            System.out.println(Arrays.toString(column));
        }

        System.out.println("------------");
        for (boolean[][] box : boxes) {
            for (boolean[] booleans : box) {
                System.out.println(Arrays.toString(booleans));
            }
        }

        System.out.println("--------------");
        System.out.println(space);
    }

    public static void main(String[] args) {
        char[][] board =
                {
                        {'5','3','.','.','7','.','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}
                };

        Solution solution = new Solution();
        solution.solveSudoku(board);
//        solution.print();
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }

    }
}
