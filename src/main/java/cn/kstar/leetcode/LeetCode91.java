package cn.kstar.leetcode;

public class LeetCode91 {

    /**
     * <h6>动态规划法</h6>
     * 
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
