package String.Leecode49;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();

        //特判
        if(strs == null || strs.length == 0)
            return ans;

        HashMap<String, List<String>> map = new HashMap<>();
        int len = strs.length;
        for (int i = 0; i < len; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String temp = new String(chars);
            if(map.containsKey(temp)){
                List<String> strings = map.get(temp);
                strings.add(strs[i]);
                map.put(temp,strings);
            }else{
                List<String> strings = new ArrayList<>();
                strings.add(strs[i]);
                map.put(temp,strings);
            }
        }

        //遍历map组装答案
        Set<String> keys = map.keySet();
        for (String key : keys) {
            ans.add(map.get(key));
        }
        return ans;
    }
}
