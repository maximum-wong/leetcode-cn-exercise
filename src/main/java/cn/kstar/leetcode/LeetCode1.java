package cn.kstar.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <h3>Two Sum
 * <br/>两数之和</h3>
 * 
 * <p>
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.<br/>
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
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
     * 暴力破解法
     * 时间复杂度：O(n^2)；空间复杂度：O(1)
     * 
     * @param  array
     * @param  target
     * @return int[]
     */
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
         * 查表法（合并赋值）
         * 每次遍历时，在哈希表中保存数组的值（key）和索引（value），
         * 算出目标值与当前数组值的差值，然后在哈希表中查找该差值，
         * 若查找到，返回当前数组的索引和在哈希表中保存的该差值的所对应的索引值
     * 
         * 时间复杂度：O(n)；空间复杂度：O(n)
     * 
     * @param array
     * @param target
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
         * 查表法（循环赋值）
     * 
         * 时间复杂度：O(n)；空间复杂度：O(n)
     * 
     * @param array
     * @param target
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
         * 双指针法（有序数组） 
         * 一个指向数组首位置的左指针和另一个指向数组末尾置的右指针，
         *  每次遍历时，如果左右指针所指向的元素值之和大于目标值，右指针向前移动一位；
         * 反之，则左指针向后移动一位；如果相等，返回做右指针所指向的数组索引值 
         * 时间复杂度：O(n)；空间复杂度：O(1)
     * 
     * @param array
     * @param target
     * @return int[]
     */
    public int[] twoSum4(int[] array, int target) {
        int[] ret = new int[2];
        int leftPointer = 0;
        int rightPointer = array.length - 1;
        int length = array.length;
        while (leftPointer + rightPointer < length) {
            if (array[leftPointer] + array[rightPointer] > target) {
                rightPointer--;
            } else if (array[leftPointer] + array[rightPointer] < target) {
                leftPointer++;
            } else {
                ret[0] = leftPointer;
                ret[1] = rightPointer;
                return ret;
            }
        }
        return ret;
    }
    
}
