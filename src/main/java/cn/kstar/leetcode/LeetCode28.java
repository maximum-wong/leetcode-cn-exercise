package cn.kstar.leetcode;

/**
 * <h6>实现strStr()</h6>
 *
 * <p>实现 strStr() 函数。给定一个 haystack 字符串和一个 needle 字符串，
 * <br/>在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。</p>
 * <pre><b>Examples: </b>
 * Input: haystack = "hello", needle = "ll"; Output: 2
 * 
 * Input: haystack = "aaaaa", needle = "aaaaa"; Output: -1
 * </pre>
 */
public class LeetCode28 {

    /**
     * <h6>暴力法</h6>
     * 
     * @param  haystack
     * @param  needle
     * @return int
     */
    public int strStr(String haystack, String needle) {
        int haystackLen = haystack.length();
        int needleLen = needle.length();
        // 主字符串位置
        int i = 0;
        // 模式字符串位置
        int j = 0;
        while (i < haystackLen && j < needleLen) {
            // 当主串和模式串字符相同时，就各自比较下一个字符
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                // 不相同时，i后退并往后走一步；j归零
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == needleLen) {
            return i - j;
        }
        return -1;
    }
}
