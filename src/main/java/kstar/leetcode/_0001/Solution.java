package kstar.leetcode._0001;

import java.util.HashMap;
import java.util.Map;

/**
 * <h6>查表法（合并赋值）</h6>
 * 
 * <p>时间复杂度：O(n)；空间复杂度：O(n)</p>
 * <p>每次遍历时，在哈希表中保存数组的值（key）和索引（value），
 * <br/>算出目标值与当前数组值的差值，然后在哈希表中查找该差值，
 * <br/>若查找到，返回当前数组的索引和在哈希表中保存的该差值的所对应的索引值</p>
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, length = nums.length; i < length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                ret[0] = map.get(complement);
                ret[1] = i;
                return ret;
            }
            map.put(nums[i], i);
        }
        return ret;
    }

}
