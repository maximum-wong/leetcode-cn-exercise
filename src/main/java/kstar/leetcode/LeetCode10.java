package kstar.leetcode;

/**
 * <h6>正则表达式匹配</h6>
 *
 * <p>给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。</p>
 * <pre>
 * '.' 匹配任意单个字符。
 * '*' 匹配零个或多个前面的元素。
 * </pre>
 * <p>匹配应该覆盖整个字符串 (s) ，而不是部分字符串。
 * <br/><b>说明：</b>
 * <br/>s 可能为空，且只包含从 a-z 的小写字母。
 * <br/>p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * </p>
 * <pre><b>Examples: </b>
 * Input: s = "aa", p = "a"; Output: false
 * Explanation: "a" 无法匹配 "aa" 整个字符串。
 * 
 * Input: s = "aa", p = "a*"; Output: true
 * Explanation: '*' 代表可匹配零个或多个前面的元素, 即可以匹配 'a' 。因此, 重复 'a' 一次, 字符串可变为 "aa"。
 * 
 * Input: s = "ab", p = ".*"; Output: true
 * Explanation: ".*" 表示可匹配零个或多个('*')任意字符('.')。
 * 
 * Input: s = "aab", p = "c*a*b"; Output: true
 * Explanation: 'c' 可以不被重复, 'a' 可以被重复一次。因此可以匹配字符串 "aab"。
 * 
 * Input: s = "mississippi", p = "mis*is*p*."; Output: true
 * </pre>
 */
public class LeetCode10 {

    /**
     * <h6>回溯法</h6>
     *
     * <p><b>解题思路：</b>
     * <ul><li>没有 '*' 的情况下，从左到右依次匹配</li>
     * <li>有 '*' 的情况下，需要考虑第一个字符是否匹配
     * <ol><li>若第一个字符匹配，子字符串就继续匹配该 pattern</li>
     * <li>若第一个字符不匹配，该字符串继续匹配 '*' 后的子 pattern</li></ol>
     * </li></ul></p>
     * @param  text
     * @param  pattern
     * @return boolean
     */
    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) {
            return text.isEmpty();
        }

        // 第一个字符是否匹配上
        boolean firstMatch = !text.isEmpty() && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.');

        // 第二个字符是'*'的情况下
        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            // 第一个字符不相等，该字符串继续匹配'*'后的子pattern；第一个字符相等，子字符串继续匹配该pattern
            return isMatch(text, pattern.substring(2)) || (firstMatch && isMatch(text.substring(1), pattern));
        } else {
            // 第二个字符不是'*'的情况下：第一个字符相等，子字符串继续匹配子pattern
            return firstMatch && isMatch(text.substring(1), pattern.substring(1));
        }
    }
}
