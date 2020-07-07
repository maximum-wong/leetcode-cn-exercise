package kstar.leetcode_cn.leetcode._0268;

/**
 * <h6>异或法</h6>
 * <p>利用XOR性质，即：a XOR a XOR b =b</p>
 */
public class Solution {

    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= i ^ nums[i];
        }
        return res;
    }
}
