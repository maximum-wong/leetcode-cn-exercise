package cn.kstar.leetcode;

/**
 * <h6>最后一个单词的长度</h6>
 *
 * <p>给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * <br/>如果不存在最后一个单词，请返回 0 。
 * <br/>说明：一个单词是指由字母组成，但不包含任何空格的字符串。</p>
 * <pre><b>Examples: </b>
 * Input: "Hello World"; Output: 5
 * </pre>
 */
public class LeetCode58 {

	/**
	 * <h6>正序法<h6>
	 * 
	 * @param s
	 * @return
	 */
	public int lengthOfLastWord(String s) {
		int ret = 0;
		if (s == null || s.length() == 0) {
			return ret;
		}

		// 每个单词的长度
		int wordLen = 0;
		for (int i = 0, len = s.length(); i < len; i++) {
			if (s.charAt(i) == ' ') {
				wordLen = 0;
			} else {
				wordLen++;
				ret = wordLen;
			}
		}

		return ret;
	}
	
	/**
	 * <h6>逆序法<h6>
	 * 
	 * @param  s
	 * @return int
	 */
	public int lengthOfLastWord2(String s) {
		int ret = 0;
		if (s == null || s.length() == 0) {
			return ret;
		}

		int i = s.length() - 1;
		while (i >= 0) {
			if (s.charAt(i) != ' ') {
				ret++;
				i--;
			} else {
				break;
			}
		}
		return ret;
	}
}
