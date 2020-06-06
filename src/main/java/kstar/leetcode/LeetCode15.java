package kstar.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h6>三数之和</h6>
 *
 * <p>给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * <br/>使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <br/>注意：答案中不可以包含重复的三元组。
 * <br/>例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，满足要求的三元组集合为：[[-1, 0, 1], [-1, -1, 2]]</p>
 */
public class LeetCode15 {

    /**
     * <h6>双指针法</h6>
     * 
     * <p>使用双指针法，将三数之和变为两数之和。
     * <br/>先将数组进行排序，然后固定数组中一个数字，将剩余两个数字用双指针法进行查找，直到只找到所有结果为止。
     * <br/>然后再固定下一个数字，继续进行以上操作，直到固定到最后一个数字为止。
     * <br/>如果相邻元素相同，则有可能会有重复的结果，需要进行跳过处理。</p>
     * @param  numbers
     * @return List<List<Integer>>
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        List<List<Integer>> result = new ArrayList<>();
        if ((numbers == null) || (numbers.length < 3)) {
            return result;
        }

        // 排序数组
        Arrays.sort(numbers);

        for (int i = 0, length = numbers.length; i < length; i++) {
            // 相邻元素如果相同，则跳过，去除重复元素
            if ((i > 0) && (numbers[i] == numbers[i - 1])) {
                continue;
            }
            // 左指针
            int left = i + 1;
            // 右指针
            int right = numbers.length - 1;
            while (left < right) {
                int sum = numbers[i] + numbers[left] + numbers[right];
                if (sum == 0) {
                    result.add(Arrays.asList(numbers[i], numbers[left], numbers[right]));
                    // 相邻元素如果相同，则跳过，去除重复元素
                    while (left < right && numbers[left] == numbers[left + 1]) {
                        left++;
                    }
                    while (left < right && numbers[right] == numbers[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
