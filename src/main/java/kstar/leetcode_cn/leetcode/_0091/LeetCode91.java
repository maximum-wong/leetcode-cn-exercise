package kstar.leetcode_cn.leetcode._0091;

/**
 * <h6>解码方法
 * <br/>Decode Ways</h6>
 *
 * <p>一条包含字母 <code>A-Z</code> 的消息通过以下方式进行了编码：
 * <br/>A message containing letters from <code>A-Z</code> is 
 * being encoded to numbers using the following mapping:</p>
 * <pre>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * </pre>
 * <p>给定一个只包含数字的<b>非空</b>字符串，请计算解码方法的总数。
 * <br/>Given a <b>non-empty</b> string containing only digits, 
 * determine the total number of ways to decode it.</p>
 * <p><b>Example 1: </b></p>
 * <pre>
 * <b>Input: </b>"12"
 * <b>Output: </b>2
 * <b>Explanation: </b>它可以解码为 "AB"（1 2）或者 "L"（12）。
 * It could be decoded as "AB" (1 2) or "L" (12).
 * </pre>
 * <p><b>Example 2: </b></p>
 * <pre>
 * <b>Input: </b>"226"
 * <b>Output: </b>3
 * <b>Explanation: </b>它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 * </pre>
 */
public class LeetCode91 {

    /**
     * <h6>动态规划法</h6>
     *
     * <p>由问题的得，动态方程为以下三种情况：</p>
     * <ol><li>当第i位为0且第i-1位为0，dp[i]=0</li>
     * <li>当第i位与第i-1位能构成合法数字且第i位不为合法数字，dp[i]=dp[i-2]</li>
     * <li>当第i位与第i-1位能构成合法数字且第i位为合法数字，dp[i]=dp[i-1]+dp[i-2]</li>
     * <li>当第i位与第i-1位不能构成合法数字且第i位为合法数字，dp[i]=dp[i-1]</li></ol>
     * @param  s
     * @return int
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int length = s.length();
        if (length == 1) {
            return 1;
        }

        int[] dp = new int[length];
        dp[0] = 1;

        if (s.charAt(1) == '0') {
            dp[1] = (s.charAt(0) == '1' || s.charAt(0) == '2') ? 1 : 0;
        } else if (s.charAt(1) >= '1' && s.charAt(1) <= '6') {
            dp[1] = (s.charAt(0) == '1' || s.charAt(0) == '2') ? 2 : 1;
        } else {
            dp[1] = s.charAt(0) == '1' ? 2 : 1;
        }

        for (int i = 2; i < length; i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    dp[i] = dp[i - 2];
                } else {
                    return 0;
                }
            } else if (s.charAt(i) >= '1' && s.charAt(i) <= '6') {
                dp[i] = (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') ? dp[i - 1] + dp[i - 2] : dp[i - 1];
            } else {
                dp[i] = s.charAt(i - 1) == '1' ? dp[i - 1] + dp[i - 2] : dp[i - 1];
            }
        }

        return dp[length - 1];
    }
    
}
