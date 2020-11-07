package String.Leetcode68.Solution1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：hodor007
 * @date ：Created in 2020/11/2
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int len = words.length;
        List<String> ans = new ArrayList<>();
        List<String> row = new ArrayList<>();
        int currentLen = 0;
        for (int i = 0; i < len; i++) {
            //如果是第一个单词或者加上空格和这个单词之后长度不超出
            if(currentLen == 0 || currentLen + words[i].length() + 1 <= maxWidth){
                row.add(words[i]);
                if(currentLen == 0){
                    currentLen += words[i].length();
                } else {
                    currentLen += words[i].length() + 1;
                }
            } else {
                //加上新单词之后长度超出了，不能加入新单词
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(row.get(0));

                //本行只有一个单词
                if(row.size() == 1){
                    stringBuilder.append(getBlanks(maxWidth - currentLen));
                } else {
                    //计算空格的总数
                    int totalBlanks = maxWidth - currentLen + row.size() - 1;
                    //计算每个间隔的平均空格数
                    int aveBlanks = totalBlanks / (row.size() - 1);
                    //计算分配后剩余的空格数
                    int remainBlanks = totalBlanks - aveBlanks * (row.size() - 1);
                    //前remainBlanks个间隔多分配一个空格
                    String blank = getBlanks(aveBlanks + 1);
                    int k = 1;
                    for (int j = 0; j < remainBlanks; j++) {
                        stringBuilder.append(blank + row.get(k));
                        k++;
                    }
                    //剩余的间隔分配aveBlank个空格
                    blank = getBlanks(aveBlanks);
                    while(k < row.size()){
                        stringBuilder.append(blank + row.get(k));
                        k++;
                    }
                }

                //答案添加到ans
                ans.add(stringBuilder.toString());
                //重置
                currentLen = 0;
                row = new ArrayList<>();
                i--;
            }
        }

        //最后一行
        if(row.size() > 0){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(row.get(0));
            int length = row.get(0).length();
            for (int i = 1; i < row.size(); i++) {
                stringBuilder.append(" " + row.get(i));
                length += row.get(i).length() + 1;
            }
            //加上剩余的空格
            stringBuilder.append(getBlanks(maxWidth - length));
            ans.add(stringBuilder.toString());
        }

        return ans;
    }

    private String getBlanks(int blankNums){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < blankNums; i++) {
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        String[] words = {"What","must","be","acknowledgment","shall","be"};
        int maxWidth = 16;
        List<String> strings = solution.fullJustify(words, maxWidth);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
