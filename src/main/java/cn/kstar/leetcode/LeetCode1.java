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
     * <h6>暴力破解法<h6>
     * 
     * <p>时间复杂度：O(n^2)；空间复杂度：O(1)</p>
     * @param  array
     * @param  target
     * @return int[]
     */
    @Deprecated
    public int[] twoSum(int[] array, int target) {
        int[] ret = new int[2];
        for (int i = 0, len1 = array.length - 1; i < len1; i++) {
            for (int j = i + 1, len2 = array.length; j < len2; j++) {
                if (target == (array[i] + array[j])) {
                    ret[0] = array[i];
                    ret[1] = array[j];
                    return ret;
                }
            }
        }
        return ret;
    }

    /**
     * <h6>查表法（合并赋值）</h6>
     * 
     * <p>时间复杂度：O(n)；空间复杂度：O(n)</p>
     * 
     * <p>每次遍历时，在哈希表中保存数组的值（key）和索引（value），
     * <br/>算出目标值与当前数组值的差值，然后在哈希表中查找该差值，
     * <br/>若查找到，返回当前数组的索引和在哈希表中保存的该差值的所对应的索引值</p>
     * @param  array
     * @param  target
     * @return int[]
     */
    public int[] twoSum2(int[] array, int target) {
        int[] ret = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, length = array.length; i < length; i++) {
            int complement = target - array[i];
            if (map.containsKey(complement)) {
                ret[0] = i;
                ret[1] = map.get(complement);
                return ret;
            }
            map.put(array[i], i);
        }
        return ret;
    }

    /**
     * <h6>查表法（循环赋值）</h6>
     * 
     * <p>时间复杂度：O(n)；空间复杂度：O(n)</p>
     * @param  array
     * @param  target
     * @return int[]
     */
    public int[] twoSum3(int[] array, int target) {
        int[] ret = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        int length = ret.length;
        for (int i = 0; i < length; i++) {
            map.put(array[i], i);
        }
        for (int i = 0; i < length; i++) {
            int complement = target - array[i];
            Integer value = map.get(complement);
            if ((value != null) && (value != i)) {
                ret[0] = i;
                ret[1] = value;
                return ret;
            }
        }
        return ret;
    }

    /**
     * <h6>排序+双指针法</h6>
     *
     * <p>时间复杂度：O(nlgn + n)；空间复杂度：O(1)</p>
     * @param array
     * @param target
     * @return
     */
    public int[] twoSum4(int[] array, int target) {
        if (array == null || array.length == 0) {
            return array;
        }

        // 对数组进行排序
        Arrays.sort(array);

        int[] ret = new int[2];
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            if (array[left] + array[right] == target) {
                ret[0] = array[left];
                ret[1] = array[right];
                return ret;
            } else if (array[left] + array[right] < target) {
                left++;
            } else {
                right--;
            }
        }

        return ret;
    }
}
