package cn.kstar.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <h3>Two Sum</h3>
 * 
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * 
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class LeetCode1 {

    /**
     * 暴力破解法
     * 时间复杂度：O(n^2)；空间复杂度：O(n)
     * 
     * @param array
     * @param target
     * @return
     */
    public int[] twoSum(int[] array, int target) {
        int[] ret = new int[2];
        for (int i = 0; i < ret.length-1; i++) {
            for (int j = i+1; j < ret.length; j++) {
                if (target == (array[i] + array[j])) {
                    ret[0]= array[i];
                    ret[1]= array[j];
                    return ret;
                }
            }
        }
        return ret;
    }
    
    /**
     * 查找表法
     * 每次遍历时，在哈希表中保存数组的值（key）和索引（value），
     * 算出目标值与当前数组值的差值，然后在哈希表中查找该差值，
     * 若查找到，返回当前数组的索引和在哈希表中保存的该差值的所对应的索引值
     * 
     * 时间复杂度：O(n)；空间复杂度：O(n)
     * 
     * @param array
     * @param target
     * @return
     */
    public int[] twoSum2(int[] array, int target) {
        int[] ret = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
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
}
