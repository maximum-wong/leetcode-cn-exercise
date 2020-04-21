package cn.kstar.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <h3>两数之和
 * <br/>Two Sum</h3>
 * 
 * <p>给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * <br/>你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * <br/>Given an array of integers, return indices of the two numbers such 
 * that they add up to a specific target. 
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * </p>
 * 
 * <pre><b>Example:</b>
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * </pre>
 */
public class LeetCode1 {

    /**
     * <h6>查表法（合并赋值）</h6>
     * 
     * <p>时间复杂度：O(n)；空间复杂度：O(n)</p>
     * <p>每次遍历时，在哈希表中保存数组的值（key）和索引（value），
     * <br/>算出目标值与当前数组值的差值，然后在哈希表中查找该差值，
     * <br/>若查找到，返回当前数组的索引和在哈希表中保存的该差值的所对应的索引值</p>
     * @param  nums
     * @param  target
     * @return
     */
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

    /**
     * <h6>查表法（循环赋值）</h6>
     * 
     * <p>时间复杂度：O(n)；空间复杂度：O(n)</p>
     * @param  nums
     * @param  target
     * @return int[]
     */
    public int[] twoSum2(int[] nums, int target) {
        int[] ret = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        int length = ret.length;
        for (int i = 0; i < length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                ret[0] = i;
                ret[1] = map.get(complement);
                return ret;
            }
        }
        return ret;
    }

    /**
     * <h6>排序+双指针法</h6>
     *
     * <p>时间复杂度：O(nlgn + n)；空间复杂度：O(1)</p>
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum3(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        // 对数组进行排序
        Arrays.sort(nums);

        // 使用双指针法
        int[] ret = new int[2];
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                ret[0] = nums[left];
                ret[1] = nums[right];
                return ret;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return ret;
    }

}
