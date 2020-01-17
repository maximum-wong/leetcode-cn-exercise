package cn.kstar.leetcode;

/**
 * <h3>Longest Substring Without Repeating Characters
 * <br/>无重复字符的最长子串</h3>
 * 
 * <p>Given a string, find the length of the longest substring without repeating characters.
 * <br/>给定一个字符串，求最长的不重复子串。</p>
 * 
 * <pre>
 * <b>Examples:</b>
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * 
 * Given "bbbbb", the answer is "b", with the length of 1.
 * 
 * Given "pwwkew", the answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * </pre>
 */
public class LeetCode3 {

    /**
     * <h6>Hash存储法</h6>
     * 
     * <p>时间复杂度：O(s.length)；空间复杂度：O(min(all.length))</p>
     * 
     * <p>使用动态规划，在一个Hash中存储已经出现的字符的上一次出现的索引值，
     * <br/>如果索引值存在, 则把当前最长子串的左边界更新为该索引值。</p>
     * 
     * @param  s
     * @return int
     */
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
            left = max(left, allChar[ch]);
            // 求出当前范围字串的长度[left, right]
            res = max(res, right - left + 1);
            // 记录当前字符的位置，+1保证[left, right]区间内没有重复字符
            allChar[ch] = right + 1;
        }
        return res;
    }

	private int max(int num1, int num2) {
		return (num1 > num2) ? num1 : num2;
	}
    
    /**
     * <h6>滑动窗口法</h6>
     * 
     * <p>时间复杂度：O(s.length)；空间复杂度：O(slideWindow.length)</p>
     * 
     * <p>建立一个128位大小的整型数组slideWindow，用来建立字符和其出现位置之间的映射。
     * </br>维护一个滑动窗口，窗口内的都是没有重复的字符，去尽可能的扩大窗口的大小，窗口不停的向右滑动。</p>
     * <li>(1) 如果当前遍历到的字符从未出现过，那么直接扩大右边界；</li>
     * <li>(2) 如果当前遍历到的字符出现过，则缩小窗口（左边索引向右移动），然后继续观察当前遍历到的字符；</li>
     * <li>(3) 重复(1)、(2)，直到左边索引无法再移动；</li>
     * <li>(4) 维护一个结果res，每次用出现过的窗口大小来更新结果res，最后返回res获取结果。</li>
     * 
     * @param  s
     * @return int
     */
    public int lengthOfLongestSubstring2(String s) {
        if ((s == null) || (s.length() == 0)) {
            return 0;
        }

        int[] slideWindow = new int[128];
        // 滑动窗口为slideWindow[left...right)
        int left = 0;
        int right = 0;
        int res = 0;
        // 整个循环从 left == 0; right == 0 这个空窗口开始
        // 到left == s.length(); right == s.length() 这个空窗口截止
        // 在每次循环里逐渐改变窗口, 维护slideWindow, 并记录当前窗口中是否找到了一个新的最优值
        int length = s.length();
        while ((left < length) && (right < length)) {
            if (slideWindow[s.charAt(right)] == 0) {
                slideWindow[s.charAt(right)]++;
                right++;
                res = max(res, right - left);
            } else { // right已经到头 || freq[s.charAt(right+1)] == 1
                slideWindow[s.charAt(left)]--;
                left++;
            }
        }

        return res;
    }
	
    public static void main(String[] args) {
        String test = "1234567812";
        LeetCode3 leetCode3 = new LeetCode3();
        int result1 = leetCode3.lengthOfLongestSubstring1(test);
        int result2 = leetCode3.lengthOfLongestSubstring2(test);
        System.out.println(result1 + ", " + result2);
    }
}
