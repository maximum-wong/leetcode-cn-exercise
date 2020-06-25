package kstar.leetcode_cn.leetcode._0139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <h6>字典+动态规划法</h6>
 * <p>字符串s[0,i-1]可以看作s1[0,j-1]和s2[j,i-1]两部分组成的，只要s1合法，并且s2合法，该字符串就合法。
 * <br/>得到转移方程为：dp[i]=dp[j]&&check(s[j,i-1])，其中check(s[j,i-1])表示s2是否出现在字典中<p/>
 */
public class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // 表示空串且合法
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
