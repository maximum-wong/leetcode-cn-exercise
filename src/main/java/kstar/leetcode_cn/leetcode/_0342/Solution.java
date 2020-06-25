package kstar.leetcode_cn.leetcode._0342;

/**
 * <h6>位操作法</h6>
 * <p>4的n次幂(n>0)的数奇数位上的数字为1，与0x55555555（0b1010101010101010101010101010101，偶数位为0，奇数位为1）相与不为0，
 * <br/>且为2的k次幂</p>
 */
public class Solution {

    public boolean isPowerOfFour(int num) {

        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
    }
}
