package cn.kstar.leetcode;

/**
 * <h3>Longest Palindromic Substring</h3>
 * <h3>最长回文子串</h3>
 * 
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * 给定一个字符串 s，找到 s中最长的回文子串。你可以假设 s的最大长度为1000。
 *
 * Example 1:
 * Input: "babad" Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * Example 2:
 * Input: "cbbd" Output: "bb"
 * 
 */
public class LeetCode5 {
    
    /**
     * dp解法
     * 
     * 动态规划进行记忆化搜索，dp最重要的是写出状态转移方程。
     * dp[i][j]表示区间[i,j]是否为回文串,那么有如下状态转移方程：
     * i = j, 即一个字符的时候，dp[i][j] = true；
     * i - j = 1，当且仅当两个字符相等的时候，是回文字符，dp[i][j]= (s[i] == s[j])
     * i - j > 1, 这个时候当前字符相等还不行，还要他们中间的字符串是回文字符串，
     * 而中间是不是回文字符串，上一轮的遍历中已经知道， 状态转移方程为：
     * dp[i][j] = (s[i] == s[j] && dp[j+1][i-1])
     * 时间复杂度是o(n^2)，空间复杂度o(n^2)
     */
    public String longestPalindromicSubstring(String s) {
        if ((s != null) && (s.length() < 1)) {
            boolean dp[][] = new boolean[s.length()][s.length()];
            int left = 0, right = 0;
            int maxLength = 0;
            for (int i=0; i<s.length(); i++) {
                dp[i][i] = true;
                for (int j=0; j<i; j++) {
                    dp[j][i] = (s.charAt(i)== s.charAt(j)) && ((i - j < 2) || dp[j+1][i-1]);
                    if (dp[j][i] && maxLength < (i-j+1)) {
                        maxLength = i - j +1;
                        left = j;
                        right = i;
                    }
                }
            }
            return s.substring(left, right+1);
        }
         return null;
    }
    
    /**
     * Manacher算法
     * 
     */
    public int manacher(String str) {
        if(str == null || str.length() < 1){
            return 0;
        }
        char[] charArr = manacherString(str);
        int[] radius = new int[charArr.length];
        int R = -1;
        int c = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < radius.length; i++) {
            radius[i] = R > i ? Math.min(radius[2*c-i],R-i+1):1;
            while(i+radius[i] < charArr.length && i - radius[i] > -1){
                if(charArr[i-radius[i]] == charArr[i+radius[i]]){
                    radius[i]++;
                }else{
                    break;
                }
            }
            if(i + radius[i] > R){
                R = i + radius[i]-1;
                c = i;
            }
            max = Math.max(max,radius[i]);
        } 
        return max-1;
    }
    
    private char[] manacherString(String str){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append("#");
            sb.append(str.charAt(i));
        }
        sb.append("#");
        return sb.toString().toCharArray();
    }
}
