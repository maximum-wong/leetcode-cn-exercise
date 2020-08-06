package kstar.leetcode_cn.leetcode._0096;

/**
 * <h6>动态规划法</h6>
 * <p>G(n): 长度为 n 的序列能构成的不同二叉搜索树的个数；F(i,n): 以 i为根、序列长度为n的不同二叉搜索树个数 (1<=i<=n)
 * <br/>则，G(n)=F(1, n)+F(2, n)+...+F(n, n)
 * <br/>当n=0或者1的时候，G(0)=1, G(1)=1
 * <br/>当以i为中心点时，则有F(i,n)=G(i-1)*G(n-i)
 * <br/>则G(n)=G(1-1)*G(n-1)+G(2-1)*G(n-2)+...+G(n-1)*G(n-n)</p>
 */
public class Solution2 {

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
