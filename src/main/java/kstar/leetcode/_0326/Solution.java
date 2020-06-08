package kstar.leetcode._0326;

/**
 * <h6>数学运算法</h6>
 * <p>在int范围内，3的n次幂最大数为1162261467，所以1162261467 mod (3^n)一定为0</p>
 */
public class Solution {

    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
