package cn.kstar.leetcode;

/**
 * <h3>Palindrome Number</h3>
 * <h3>回文数</h3>
 * 
 * Determine whether an integer is a palindrome.
 * An integer is a palindrome when it reads the same backward as forward.
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 
 * Examples:
 * 
 * Input: 121 Output: true
 * 
 * Input: -121 Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-.
 * Therefore it is not a palindrome.
 * 
 * Input: 10 Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 */
public class LeetCode9 {

    /**
     * desc:使用字符串反转后的值与原先的字符串进行比较（不推荐）
     * 
     * @param x
     * @return boolean
     */
    @Deprecated
    public boolean isPalindrome1(int x) {
        String origin = String.valueOf(x);
        String result = new StringBuilder(origin).reverse().toString();
        return result.equals(origin);
    }

    /**
     * desc:转为字符数组使用双指针法
     * 
     * @param x
     * @return boolean
     */
    public boolean isPalindrome2(int x) {
        // 将整数转为字符数组
        char[] charArray = String.valueOf(x).toCharArray();
        // 左指针
        int left = 0;
        // 右指针
        int right = charArray.length - 1;
        // 遍历字符串
        while (left < right) {
            // 当左指针和右指针指向的字符不同时，返回false
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * desc:使用整数反转的方式
     * 
     * @param x
     * @return boolean
     */
    public boolean isPalindrome3(int x) {
        if (x < 0) {
            return false;
        }
        long origin = x;
        // 反转后结果，考虑会溢出
        long reverseNum = 0;
        while (x != 0) {
            reverseNum = reverseNum * 10 + x % 10;
            x /= 10;
        }
        return origin == reverseNum;
    }
    
    /**
     * desc:求出左半部分和右半部分的数字进行比较
     * 
          * 负数和个位数上为0的非0数字不是回文数，其余数字要判断左半部分和右半部分是否相等。
     * (1)整数位数为偶数个：
     * |------|--------|------------------|----------|
     * | 数字 | 个位数 | 翻转后得到的数字 | 剩余数字 |
     * | 1221 | 1      | 0*10+1=1         | 122      |
     * | 122  | 2      | 1*10+2=12        | 12       |
     * |------|--------|------------------|----------|
          * 剩余数字和翻转数字相等，退出翻转，为回文数。
     * (2)整数位数为奇数个：
     * |-------|--------|------------------|----------|
     * | 数字  | 个位数 | 翻转后得到的数字 | 剩余数字 |
     * | 12321 | 1      | 0*10+1=1         | 1232     |
     * | 1232  | 2      | 1*10+2=12        | 123      |
     * | 123   | 3      | 12*10+3=123      | 12       |
     * |-------|--------|------------------|----------|
          * 剩余数字小于翻转数字，退出翻转。因为3为中心数，去掉3，两边相等，为回文数。
     * 
     * @param x
     * @return
     * boolean
     */
    public boolean isPalindrome4(int x) {
        // 排除负数和个位数上为0的非0数字
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reverseNum = 0;

        // 翻转
        while (x > reverseNum) {
            reverseNum = reverseNum * 10 + x % 10;
            x /= 10;
        }
        return reverseNum == x || reverseNum / 10 == x;

    }
    
}
