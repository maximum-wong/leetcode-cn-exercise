package kstar.leetcode;

/**
 * <h6>验证回文串</h6>
 * 
 * <p>给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <br/><b>说明：</b>本题中，我们将空字符串定义为有效的回文串。</p>
 * <pre><b>Examples: </b>
 * Input: "A man, a plan, a canal: Panama"; Output: true
 * 
 * Input: "race a car"; Output: false
 * </pre>
 */
public class LeetCode125 {

    /**
     * <h6>双指针法</6>
     * 
     * @param  s
     * @return boolean
     */
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        // 空字符串是回文串
        if (s.length() == 0) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            // 左右指针所指向的字符不是字母和数字，做相应的移动处理
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            // 左右指针分别指向的字符不相等，不是回文串
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
