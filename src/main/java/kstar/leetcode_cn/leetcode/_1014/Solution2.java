package kstar.leetcode_cn.leetcode._1014;

/**
 * <h6>动态规划法</h6>
 * <p>对于景点n状态只有两个：当前选一个点dp0[n]；当前没有选点dp1[n]
 * <br/>选了一个点的得分计算：基于前面已选一个点value=dp0[n-1]-1；选当前点n，value=A[i]
 * <br/>没有选的情况：前面已选完。或没有开始选value=dp1[n-1]；当前点为结束点,value=dp0[n-1]+A[i]-1
 * <br/>状态方程为：dp0[n]=max(dp0[n-1]-1, A[i]); dp1[n]=max(dp1[n-1], dp0[n-1]+A[i]-1)
 * <br/>初始值 n=0：dp0[0]=A[0], dp1[0]=0</p>
 */
public class Solution2 {

    public int maxScoreSightseeingPair(int[] A) {

        if (A == null) {
            return 0;
        }

        if (A.length < 2) {
            return A[0];
        }

        int dp0 = A[0];
        int dp1 = 0;
        for (int i = 1; i < A.length; i++) {
            int tmp = dp0;
            dp0 = Math.max(dp0 - 1, A[i]);
            dp1 = Math.max(dp1, tmp + A[i] - 1);
        }
        return dp1;
    }
}
