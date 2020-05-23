package cn.kstar.leetcode.leetcode30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h6>滑动窗口法</h6>
 */
public class Solution {

    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();

        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        // 用哈希表存储words数组中的所有word与其出现次数之间的映射
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // words数组的长度
        int allWords = words.length;

        // 每个word的长度
        int aWord = words[0].length();

        for (int i = 0; i < aWord; i++) {

            int start = i; // 窗口左边界
            int end = i; // 窗口右边界
            int flag = 0; // 匹配的单词个数
            Map<String, Integer> tmp = new HashMap<>();
            // 滑动窗口
            while (end + aWord <= s.length()) {
                // 取单词
                String word = s.substring(end, end + aWord);
                // 右界右移
                end += aWord;
                // 匹配成功，添加至tmp
                if (map.containsKey(word)) {
                    tmp.put(word, tmp.getOrDefault(word, 0) + 1);
                    flag++;
                    // 一个单词匹配多次，左边界右移
                    while (tmp.getOrDefault(word, 0) > map.getOrDefault(word, 0)) {
                        tmp.put(s.substring(start, start + aWord),
                                tmp.getOrDefault(s.substring(start, start + aWord), 0) - 1);
                        flag--;
                        start += aWord;
                    }
                    if (flag == allWords) {
                        result.add(start);
                    }
                } else { // 匹配失败，重置各项条件
                    tmp.clear();
                    flag = 0;
                    start = end;
                }
            }
        }
        return result;
    }

}
