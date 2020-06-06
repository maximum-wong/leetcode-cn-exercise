package kstar.leetcode._0038;

/**
 * <h6>递归法</h6>
 *<p>根据题意得，求第n项的前提是知道第n-1项，因此需要递归来解决。</p>
 */
public class Solution {

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        StringBuilder sb = new StringBuilder();
        int flag = 0;
        int i;
        String s = countAndSay(n - 1);
        for (i = 1; i < s.length(); i++) {
            // 当前字符串与紧邻字符串不相等时，更新此结果
            if (s.charAt(flag) != s.charAt(i)) {
                sb.append(i - flag).append(s.charAt(flag));
                flag = i;
            }
        }
        return sb.append(i - flag).append(s.charAt(flag)).toString();
    }
}
