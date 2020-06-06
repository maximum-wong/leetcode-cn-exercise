package kstar.leetcode;

import java.util.Arrays;

/**
 * <h6>最接近的三数之和</h6>
 *
 * <p>给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * <br/>找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。
 * <br/>假定每组输入只存在唯一答案。
 * <br/>例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).</p>
 */
public class LeetCode16 {

    /**
     * <h6>双指针法</h6>
     *
     * <p>使用双指针法，将三数之和变为两数之和。
     * <br/>先将数组进行排序，然后固定数组中一个数字，将剩余两个数字用双指针法进行查找，获取结果。
     * <br/>获取的结果再与目标值进行比较，选取较小结果，直到两个指针重合为止。
     * <br/>然后再固定下一个数字，继续进行以上操作，直到固定到最后一个数字为止。</p>
     * @param  numbers
     * @param  target
     * @return int
     */
    public int threeSumClosest(int[] numbers, int target) {
        // 排序数组
        Arrays.sort(numbers);
        int result = numbers[0] + numbers[1] + numbers[2];
        for (int i = 0, length = numbers.length; i < length; i++) {
            // 左指针
            int left = i + 1;
            // 右指针
            int right = numbers.length - 1;
            while (left < right) {
                int current = numbers[i] + numbers[left] + numbers[right];
                // 选取较小的结果
                if (abs(result - target) > abs(target - current)) {
                    result = current;
                }
                if (current < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    private int abs(int input) {
        return (input ^ (input >> 31)) - (input >> 31);
    }
}
