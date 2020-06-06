package kstar.leetcode;

/**
 * <h6>2的幂</h6>
 *
 * <p>给定一个整数，编写一个函数来判断它是否是 2 的幂次方。</p>
 * <pre><b>Examples: </b>
 * <b>Example 1: </b>
 * Input：1; Output: true
 * Explanation: 2^0=1
 * 
 * <b>Example 2: </b>
 * Input：16; Output: true
 * Explanation: 2^4=16
 * 
 * <b>Example 3: </b>
 * Input：218; Output: false
 * </pre>
 */
public class LeetCode231 {

    /**
     * <h6>位移法<h6>
     * 
     * <p>n循环向右移动，判断最低位是否为0，直到最低位不为0为止。</p>
     * 
     * @param  n
     * @return boolean
     */
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        while ((n & 1) == 0) {
            n >>= 1;
        }
        if (n == 1) {
            return true;
        }
        return false;
    }

    /**
     * <p><b>解题思路：</b>
     * <br/>一个数是2的幂次方，有以下规律：n&(n-1)=0</p>
     *
     * @param  n
     * @return boolean
     */
    public boolean isPowerOfTwo2(int n) {
        return (n > 0) && ((n & n - 1) == 0);
    }
}
