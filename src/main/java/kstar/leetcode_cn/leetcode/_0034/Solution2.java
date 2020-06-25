package kstar.leetcode_cn.leetcode._0034;

/**
 * <h6>线性查找法</h6>
 * <p>时间复杂度：O(n)；空间复杂度：O(1)</p>
 *
 */
@Deprecated
public class Solution2 {

    /**
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] ret = { -1, -1 };

        // 从前往后查找第一个位置
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                ret[0] = i;
                break;
            }
        }

        if (ret[0] == -1) {
            return ret;
        }

        // 从后往前查找最后个位置
        for (int i = ret.length - 1; i >= 0; i--) {
            if (nums[i] == target) {
                ret[1] = i;
                break;
            }
        }

        return ret;
    }
}
