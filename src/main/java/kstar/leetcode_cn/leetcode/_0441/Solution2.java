package kstar.leetcode_cn.leetcode._0441;

/**
 * <h6>递推法</h6>
 */
public class Solution2 {

    public int arrangeCoins(int n) {
        int k = 1;
        while (n >= k) {
            n -= k++;
        }
        return k-1;
    }
}
