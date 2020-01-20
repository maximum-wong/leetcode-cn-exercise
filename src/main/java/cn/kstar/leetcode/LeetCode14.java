package cn.kstar.leetcode;

/**
 * <h6>最长公共前缀</h6>
 *
 * <p>编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。</p>
 * 
 * <pre>
 * 输入: ["flower","flow","flight"]；输出: "fl"
 * 输入: ["dog","racecar","car"]；输出: ""；解释: 输入不存在公共前缀。
 * </pre>
 */
public class LeetCode14 {

	/**
	 * <p>遍历，遇到字符串不同，或者字符串超出遍历的长度就返回。</p>
	 * 
	 * @param  strs
	 * @return String
	 */
	public String longestCommonPrefix(String[] strs) {
		int index = 0;
		if (strs.length == 0) {
			return "";
		}
		for (int i = 0, length = strs[0].length(); i < length; i++) {
			char currentChar = strs[0].charAt(index);
			for (int j = 0, len = strs.length; j < len; j++) { // 比较每个字符串相应位置上的值
				if ((strs[i].length() == i) || (currentChar != strs[i].charAt(index))) {
					return strs[i].substring(0, index);
				}
			}
			index++;
		}
		return strs[0].substring(0, index);
	}
}
