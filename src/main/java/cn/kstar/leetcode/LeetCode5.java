package cn.kstar.leetcode;

/**
 * <h3>Longest Palindromic Substring
 * <br/>最长回文子串</h3>
 * 
 * <p>Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <br/>给定一个字符串 s，找到 s中最长的回文子串。你可以假设 s的最大长度为1000。<p>
 * 
 * <pre>
 * <b>Example 1:</b>
 * Input: "babad" Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * <b>Example 2:</b>
 * Input: "cbbd" Output: "bb"
 * </pre>
 * 
 */
public class LeetCode5 {
    
	/**
	 * <h6>中心扩展法</h6>
	 * 
	 * <p>时间复杂度：O(n^2)；空间复杂度：O(1)</p>
	 * 
	 * <p>因为回文串是对称的，所以可以每次循环选择一个中心，进行左右扩展，判断左右字符是否相等即可。
	 * <br/>由于存在奇数个数的字符串和偶数个数的字符串，所以需要从一个字符开始扩展，或从两个字符之间开始扩展，
	 * <br/>所以总共有 n + n - 1 个中心。</p>
	 * 
	 * @param  s
	 * @return String
	 */
	public String longestPalindromicSubstring(String s) {
		if (s == null || s.length() <= 1) {
			return s;
		}

		// 起始位置
		int start = 0;
		// 结束位置
		int end = 0;
		for (int i = 0, length = s.length(); i < length; i++) {
			// 计算偶数长度字符串的结果
			int result1 = expandAroundCenter(s, i, i+1);
			// 计算奇数长度字符串的结果
			int result2 = expandAroundCenter(s, i, i);
			// 计算比较长的结果的起始位置和终止位置
			int result = max(result1, result2);
			if (result > end - start) {
				start = i - (result - 1) / 2;
				end = i + result / 2;
			}
		}

		return s.substring(start, end + 1);
	}

	private int expandAroundCenter(String input, int left, int right) {
		int leftIndex = left;
		int rightIndex = right;
		int length = input.length();
		while ((leftIndex >= 0) && (rightIndex < length) && (input.charAt(leftIndex) == input.charAt(rightIndex))) {
			leftIndex--;
			rightIndex++;
		}
		return rightIndex - leftIndex - 1;
	}

	private int max(int x, int y) {
		return (x > y) ? x : y;
	}

	private int min(int x, int y) {
		return (x < y) ? x : y;
	}
	
    /**
     * <h6>dp解法</h6>
     * 
     * <p>时间复杂度是o(n^2)，空间复杂度o(n^2)</p>
     * 
     * <p>动态规划进行记忆化搜索，dp最重要的是写出状态转移方程。
     * <br/>dp[i][j]表示区间[i,j]是否为回文串,那么有如下状态转移方程：
     * <li>i = j, 即一个字符的时候，dp[i][j] = true；</li>
     * <li>i - j = 1，当且仅当两个字符相等的时候，是回文字符，dp[i][j]= (s[i] == s[j])</li>
     * <li>i - j > 1, 这个时候当前字符相等还不行，还要他们中间的字符串是回文字符串，而中间是不是回文字符串，上一轮的遍历中已经知道， 状态转移方程为：
     * dp[i][j] = (s[i] == s[j] && dp[j+1][i-1])</li></p>
     * 
     * @param  str
     * @return String
     */
    public String longestPalindromicSubstring2(String s) {
        if ((s != null) && (s.length() > 1)) {
            int length = s.length();
            boolean dp[][] = new boolean[length][length];
            int left = 0;
            int right = 0;
            int maxLength = 0;
            for (int i = 0; i < length; i++) {
                dp[i][i] = true;
                for (int j = 0; j < i; j++) {
                    dp[j][i] = (s.charAt(i) == s.charAt(j)) && ((i - j < 2) || dp[j + 1][i - 1]);
                    if (dp[j][i] && maxLength < (i - j + 1)) {
                        maxLength = i - j + 1;
                        left = j;
                        right = i;
                    }
                }
            }
            return s.substring(left, right + 1);
        }
        return s;
    }
    
    /**
     * <h6>Manacher算法</h6>
     * 
     * @param  str
     * @return int
     */
    public int manacher(String str) {
        if (str == null || str.length() < 1) {
            return 0;
        }
        char[] charArr = manacherString(str);
        int length = charArr.length;
        int[] radius = new int[length];
        int r = -1;
        int c = -1;
        int max = 0X80000000;
        for (int i = 0; i < length; i++) {
            radius[i] = r > i ? min(radius[2 * c - i], r - i + 1) : 1;
            while (i + radius[i] < charArr.length && i - radius[i] > -1) {
                if (charArr[i - radius[i]] == charArr[i + radius[i]]) {
                    radius[i]++;
                } else {
                    break;
                }
            }
            if (i + radius[i] > r) {
                r = i + radius[i] - 1;
                c = i;
            }
            max = max(max, radius[i]);
        }
        return max - 1;
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
