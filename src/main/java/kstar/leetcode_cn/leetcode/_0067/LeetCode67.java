package kstar.leetcode_cn.leetcode._0067;

/**
 * <h6>二进制求和</h6>
 * 
 * <p>给定两个二进制字符串，返回他们的和（用二进制表示）。
 * <br/>输入为非空字符串且只包含数字 1 和 0。</p>
 * <pre><b>Examples: </b>
 * Input: a = "11", b = "1"; Output: "100";
 * 
 * Input: a = "1010", b = "1011"; Output: "10101";
 * </pre>
 */
public class LeetCode67 {

    public String addBinary(String a, String b) {
        int len = a.length() > b.length() ? a.length() : b.length();
        char[] ret = new char[len];
        // 进位数
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        int index = len - 1;
        while (index >= 0) {
            if (i >= 0) {
                carry += (a.charAt(i--) - '0');
            }
            if (j >= 0) {
                carry += (b.charAt(j--) - '0');
            }
            ret[index--] = (char) (carry % 2 + '0');
            carry >>= 1;
        }
        if (carry != 0) { // 处理位数增加的情况
            char[] newRet = new char[len + 1];
            newRet[0] = (char) (carry + '0');
            System.arraycopy(ret, 0, newRet, 1, len);
            return new String(newRet);
        }
        return new String(ret);
    }
}
