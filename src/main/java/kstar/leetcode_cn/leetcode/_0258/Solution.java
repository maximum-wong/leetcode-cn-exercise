package kstar.leetcode_cn.leetcode._0258;

/**
 * <h6>数根公式</h6>
 */
public class Solution {

    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}
