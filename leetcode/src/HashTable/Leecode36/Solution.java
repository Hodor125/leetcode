package HashTable.Leecode36;

import java.util.HashMap;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer,Integer>[] rows = new HashMap[9];
        HashMap<Integer,Integer>[] columns = new HashMap[9];
        HashMap<Integer,Integer>[] boxes = new HashMap[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                //计算所属的小区域
                int index = (i / 3) * 3 + j / 3;

                if('.' != board[i][j]){
                    int num = (int)board[i][j];
                    //计算每个空格的数字在行、列、小区域中数显的次数
                    //使用getOrDefault查询，查询不到则为默认值0，适用于本题的情况
                    rows[i].put(num, rows[i].getOrDefault(num,0) + 1);
                    columns[j].put(num, columns[j].getOrDefault(num,0) + 1);
                    boxes[index].put(num, boxes[index].getOrDefault(num,0) + 1);

                    if(rows[i].get(num) > 1 || columns[j].get(num) > 1 || boxes[index].get(num) > 1){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
