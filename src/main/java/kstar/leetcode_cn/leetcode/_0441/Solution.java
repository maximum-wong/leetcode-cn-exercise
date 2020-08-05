package kstar.leetcode_cn.leetcode._0441;

/**
 * <h6>公式法</h6>
 * <p>利用公式，k(k+1)/2=n，得到整数解为k=sqrt(2n+1/4)-1/2</p>
 */
public class Solution {

    public int arrangeCoins(int n) {
        return (int) (Math.sqrt(2.0 * n + 0.25) - 0.5);
    }
}
