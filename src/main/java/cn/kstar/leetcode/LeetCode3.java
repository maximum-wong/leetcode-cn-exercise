package cn.kstar.leetcode;

/**
 * <h3>Longest Substring Without Repeating Characters</h3>
 * 
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 * 给一个字符串，求最长的不重复子串。
 * 
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LeetCode3 {

    /**
     * Hash存储法
     * 
     * 使用动态规划，在一个Hash中存储已经出现的字符的上一次出现的索引值，
     *  如果索引值存在, 则把当前最长子串的左边界更新为该索引值
     * 
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int[] allChar = new int[256];
        int res = 0;
        // 字符串的起点下标记
        int left = -1;
        for (int i = 0; i < s.length(); i++) {
            // left 就是遍历之前的没有出现的字符
            left = Math.max(left, allChar[s.charAt(i)]);
            // 更新出现过的字符位置
            allChar[s.charAt(i)] = i;
            // 遍历到当前字符串，最大的要么之前的最大的长；要么就是left到当前字符的步长
            res = Math.max(res, i - left);
        }
        return res;
    }
    
    /**
     * 滑动窗口法
     * 
     * 建立一个256位大小的整型数组freg，用来建立字符和其出现位置之间的映射。
     * 维护一个滑动窗口，窗口内的都是没有重复的字符，去尽可能的扩大窗口的大小，窗口不停的向右滑动。
     * （1）如果当前遍历到的字符从未出现过，那么直接扩大右边界；
     * （2）如果当前遍历到的字符出现过，则缩小窗口（左边索引向右移动），然后继续观察当前遍历到的字符；
     * （3）重复（1）（2），直到左边索引无法再移动；
     * （4）维护一个结果res，每次用出现过的窗口大小来更新结果res，最后返回res获取结果。
     * 
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        int[] freq = new int[256];
        int l = 0; //滑动窗口为s[l...r]
        int r = -1;
        int res = 0;
        // 整个循环从 l == 0; r == -1 这个空窗口开始
        // 到l == s.size(); r == s.size()-1 这个空窗口截止
        // 在每次循环里逐渐改变窗口, 维护freq, 并记录当前窗口中是否找到了一个新的最优值
        while (l < s.length()) {
            if (((r+1) < s.length()) && (freq[s.charAt(r+1)] == 0)) {
                r++;
                freq[s.charAt(r)]++;
            } else { //r已经到头 || freq[s.charAt(r+1)] == 1
                freq[s.charAt(l)]--;
                l++;
            }
            res = Math.max(res, r-l+1);
        }
        
        return res;
    }
}
