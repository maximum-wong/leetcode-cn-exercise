package kstar.leetcode_cn.leetcode._0096;

/**
 * <h6>公式法</h6>
 * <p>卡特兰（Catalan）数：C<sub>0</sub>=1; C<sub>n+1</sub>=2(2n+1)*C<sub>n</sub>/(n+2)</p>
 */
public class Solution {

    public int numTrees(int n) {
        long catalan = 1L;
        for (int i = 0; i < n; i++) {
            catalan = catalan * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) catalan;
    }
}
