package cn.kstar.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <h6>括号生成</h6>
 *
 * <p>给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。</p>
 * <pre><b>Examples: </b>
 * 给出 n = 3，生成结果为：
 * [
 *     "((()))",
 *     "(()())",
 *     "(())()",
 *     "()(())",
 *     "()()()"
 * ]
 * </pre>
 */
public class LeetCode22 {

	/**
	 * <h6>递归法</h6>
	 *
	 * <p>使用递归法：首先左右括号必须相等。
	 * <br/><b>先确定前缀，然后递归，</b>递归条件就是剩下的左括号数目，和剩下的右括号数目。</p>
	 * @param  n
	 * @return List<String>
	 */
	public List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<>();
		parenthesis(list, "", n, n);
		return list;
	}

	private void parenthesis(List<String> list, String s, int left, int right) {
		// 终止条件，向list中添加一个返回结果
		if (left == 0 && right == 0) {
			list.add(s);
		}

		// 在左边已生成一个'('的情况下，递归生成其余部分
		if (left > 0) {
			parenthesis(list, s + '(', left - 1, right);
		}

		// 在右边已生成一个')'的情况下，递归生成其余部分
		if (right > 0 && left < right) {
			parenthesis(list, s + ')', left, right - 1);
		}
	}
}
