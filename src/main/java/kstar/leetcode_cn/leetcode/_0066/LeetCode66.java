package kstar.leetcode_cn.leetcode._0066;

/**
 * <h6>加一</h6>
 *
 * <p>给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <br/>最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * <br/>你可以假设除了整数 0 之外，这个整数不会以零开头。</p>
 * <pre><b>Examples: </b>
 * Input: [1,2,3]; Output: [1,2,4]
 * Explanation: 输入数组表示数字 123。
 * 
 * Input: [4,3,2,1]; Output: [4,3,2,2]
 * Explanation: 输入数组表示数字 4321。
 * </pre>
 */
public class LeetCode66 {

    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }

        // 进位数
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }
        if (carry != 0) { // 处理位数增加的情况
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = carry;
            System.arraycopy(digits, 0, newDigits, 1, digits.length);
            return newDigits;
        }
        return digits;
    }
}
