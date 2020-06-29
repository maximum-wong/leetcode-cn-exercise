package kstar.leetcode_cn.leetcode._0049;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h6>计数分类+查表法</h6>
 * <p>时间复杂度：O(n*k)；空间复杂度：O(n*k)</p>
 */
public class Solution2 {

    public List<List<String>> groupAnagrams(String[] strs) {

        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();
        // 用数组记录出现的字母
        int[] count = new int[26];

        for (String str : strs) {
            // 重置数组
            Arrays.fill(count, 0);
            // 记录字符串中出现字母
            for (char ch : str.toCharArray()) {
                count[ch - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < count.length; i++) {
                sb.append('#').append(count[i]);
            }

            String key = sb.toString();
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
