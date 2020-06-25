package kstar.leetcode_cn.leetcode._0003;

/**
 * <h6>Hash存储法</h6>
 *
 * <p>时间复杂度：O(s.length)；空间复杂度：O(min(all.length))</p>
 * <p>使用动态规划，在一个Hash中存储已经出现的字符的上一次出现的索引值，
 * <br/>如果索引值存在, 则把当前最长子串的左边界更新为该索引值。</p>
 */
public class Solution {

    public int lengthOfLongestSubstring1(String s) {
        if ((s == null) || (s.length() == 0)) {
            return 0;
        }

        int[] allChar = new int[128];
        int res = 0;
        // 字符串的起点下标记
        int left = 0;
        for (int right = 0, length = s.length(); right < length; right++) {
            char ch = s.charAt(right);
            // left更新到重复字符的下一个索引位置
            left = Math.max(left, allChar[ch]);
            // 求出当前范围字串的长度[left, right]
            res = Math.max(res, right - left + 1);
            // 记录当前字符的位置，+1保证[left, right]区间内没有重复字符
            allChar[ch] = right + 1;
        }
        return res;
    }

}
