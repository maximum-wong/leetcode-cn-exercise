package kstar.leetcode_cn.leetcode._0049;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h6>字符串排序+查表法</h6>
 * <p>时间复杂度：O(n*k*log k)；空间复杂度：O(n*k)</p>
 */
public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String key = String.valueOf(chs);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }

        return new ArrayList<>(map.values());
    }
}
