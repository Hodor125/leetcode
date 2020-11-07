package String.Leetcode68.OthersSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：hodor007
 * @date ：Created in 2020/11/1
 * @description ：
 * @version: 1.0
 */
public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        //当前行单词已经占用的长度
        int currentLen = 0;
        //保存当前行的单词
        List<String> row = new ArrayList<>();
        //遍历每个单词
        for (int i = 0; i < words.length;) {
            //判断加入该单词是否超过最长长度
            //分了两种情况，一种情况是加入第一个单词，不需要多加 1
            //已经有单词的话，再加入单词，需要多加个空格，所以多加了 1
            if (currentLen == 0 && currentLen + words[i].length() <= maxWidth
                    || currentLen > 0 && currentLen + 1 + words[i].length() <= maxWidth) {
                row.add(words[i]);
                if (currentLen == 0) {
                    currentLen = currentLen + words[i].length();
                } else {
                    currentLen = currentLen + 1 + words[i].length();
                }
                i++;
                //超过的最长长度，对 row 里边的单词进行处理
            } else {
                //计算有多少剩余，也就是总共的空格数，因为之前计算 currentLen 多算了一个空格，这里加回来
                int sub = maxWidth - currentLen + row.size() - 1;
                //如果只有一个单词，那么就直接单词加空格就可以
                if (row.size() == 1) {
                    String blank = getStringBlank(sub);
                    ans.add(row.get(0) + blank);
                } else {
                    //用来保存当前行的结果
                    StringBuilder temp = new StringBuilder();
                    //将第一个单词加进来
                    temp.append(row.get(0));
                    //计算平均空格数
                    int averageBlank = sub / (row.size() - 1);
                    //如果除不尽，计算剩余空格数
                    int missing = sub - averageBlank * (row.size() - 1);
                    //前 missing 的空格数比平均空格数多 1
                    String blank = getStringBlank(averageBlank + 1);
                    int k = 1;
                    for (int j = 0; j < missing; j++) {
                        temp.append(blank + row.get(k));
                        k++;
                    }
                    //剩下的空格数就是求得的平均空格数
                    blank = getStringBlank(averageBlank);
                    for (; k < row.size(); k++) {
                        temp.append(blank + row.get(k));
                    }
                    //将当前结果加入
                    ans.add(temp.toString());

                }
                //清空以及置零
                row = new ArrayList<>();
                currentLen = 0;

            }
        }
        //单独考虑最后一行，左对齐
        StringBuilder temp = new StringBuilder();
        temp.append(row.get(0));
        for (int i = 1; i < row.size(); i++) {
            temp.append(" " + row.get(i));
        }
        //剩余部分用空格补齐
        temp.append(getStringBlank(maxWidth - currentLen));
        //最后一行加入到结果中
        ans.add(temp.toString());
        return ans;
    }
    //得到 n 个空白
    private String getStringBlank(int n) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            str.append(" ");
        }
        return str.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        List<String> strings = solution.fullJustify(words, maxWidth);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
