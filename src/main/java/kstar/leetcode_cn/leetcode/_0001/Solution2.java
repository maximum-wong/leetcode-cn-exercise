package kstar.leetcode_cn.leetcode._0001;

import java.util.HashMap;
import java.util.Map;

/**
 * <h6>查表法（循环赋值）</h6>
 * 
 * <p>时间复杂度：O(n)；空间复杂度：O(n)</p>
 */
public class Solution2 {

    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        int length = ret.length;
        for (int i = 0; i < length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                ret[0] = i;
                ret[1] = map.get(complement);
                return ret;
            }
        }
        return ret;
    }

}
