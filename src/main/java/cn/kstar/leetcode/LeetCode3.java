package cn.kstar.leetcode;

/**
 * <h3>Longest Substring Without Repeating Characters</h3>
 * <h3>无重复字符的最长子串</h3>
 * 
 * <p>Given a string, find the length of the longest substring without repeating characters.
 * <br/>给定一个字符串，求最长的不重复子串。</p>
 * 
 * <pre>
 * Examples:
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
     * <p>时间复杂度：O(s.length)；空间复杂度：O(allChar.length)</p>
     * 
     * <p>使用动态规划，在一个Hash中存储已经出现的字符的上一次出现的索引值，
     * <br/>如果索引值存在, 则把当前最长子串的左边界更新为该索引值。</p>
     * 
     * @param s
     * @return int
     */
	public int lengthOfLongestSubstring(String s) {
		int[] allChar = new int[256];
		int res = 0;
		// 字符串的起点下标记
		int left = -1;
		for (int i = 0, length = s.length(); i < length; i++) {
			// left 就是遍历之前的没有出现的字符
			left = max(left, allChar[s.charAt(i)]);
			// 更新出现过的字符位置
			allChar[s.charAt(i)] = i;
			// 遍历到当前字符串，最大的要么之前的最大的长；要么就是left到当前字符的步长
			res = max(res, i - left);
		}
		return res;
	}
    
	private int max(int num1, int num2) {
		return (num1 > num2) ? num1 : num2;
	}
    
    /**
     * <h6>滑动窗口法</h6>
     * 
     * <p>时间复杂度：O(s.length)；空间复杂度：O(freq.length)</p>
     * 
     * <p>建立一个256位大小的整型数组freg，用来建立字符和其出现位置之间的映射。
     * </br>维护一个滑动窗口，窗口内的都是没有重复的字符，去尽可能的扩大窗口的大小，窗口不停的向右滑动。</p>
     * <li>(1) 如果当前遍历到的字符从未出现过，那么直接扩大右边界；</li>
     * <li>(2) 如果当前遍历到的字符出现过，则缩小窗口（左边索引向右移动），然后继续观察当前遍历到的字符；<li>
     * <li>(3) 重复(1)、(2)，直到左边索引无法再移动；<li>
     * <li>(4) 维护一个结果res，每次用出现过的窗口大小来更新结果res，最后返回res获取结果。<li>
     * 
     * @param s
     * @return
     */
	public int lengthOfLongestSubstring2(String s) {
		int[] freq = new int[256];
		int left = 0; // 滑动窗口为s[left...right]
		int right = -1;
		int res = 0;
		// 整个循环从 left == 0; right == -1 这个空窗口开始
		// 到left == s.length(); right == s.length()-1 这个空窗口截止
		// 在每次循环里逐渐改变窗口, 维护freq, 并记录当前窗口中是否找到了一个新的最优值
		int length = s.length();
		while (left < length) {
			if (((right + 1) < length) && (freq[s.charAt(right + 1)] == 0)) {
				right++;
				freq[s.charAt(right)]++;
			} else { // right已经到头 || freq[s.charAt(right+1)] == 1
				freq[s.charAt(left)]--;
				left++;
			}
			res = max(res, right - left + 1);
		}

		return res;
	}
}
