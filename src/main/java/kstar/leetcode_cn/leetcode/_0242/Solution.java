package kstar.leetcode_cn.leetcode._0242;

/**
 * <h6>查表法</h6>
 */
public class Solution {

    public boolean isAnagram(String s, String t) {
        // 两个字符长度不相等，直接返回false
        if (s.length() != t.length()) {
            return false;
        }

        // 定义一个表用来统计字符串t中每个字符出现的次数
        int[] table = new int[26];
        // 遍历字符串s，统计每个字母现的次数
        for (int i = 0, length = s.length(); i < length; i++) {
            table[s.charAt(i) - 'a']++;
        }
        // 遍历字符串t，减少每一个出现字母的频次
        for (int i = 0, length = t.length(); i < length; i++) {
            table[t.charAt(i) - 'a']--;
            // t中包含一个不存在于s中的一个字母
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
