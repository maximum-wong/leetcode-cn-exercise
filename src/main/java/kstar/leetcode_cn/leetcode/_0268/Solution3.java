package kstar.leetcode_cn.leetcode._0268;

/**
 * <h6>抵消法（高斯求和法的改进版）</h6>
 * <p>利用a-a+b-c+c-0=b的性质求出缺失数</p>
 */
public class Solution3 {

    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int res = 0;
        int n = nums.length;
        for (int i = 0; i <= n; i++) {
            res += i - (i < n ? nums[i] : 0);
        }

        return res;
    }
}
