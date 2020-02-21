package cn.kstar.leetcode;

import java.util.Arrays;

/**
 * <h6>有效三角形的个数</h6>
 *
 * <p>给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
 * <br/>Given an array consists of non-negative integers, 
 * your task is to count the number of triplets chosen from the array 
 * that can make triangles if we take them as side lengths of a triangle.</p>
 * <pre><b>Example1: </b>
 * Input: [2,2,3,4]
 * Output: 3
 * Explanation：有效的组合是: 2,3,4 (使用第一个 2) 2,3,4 (使用第二个 2) 2,2,3
 * Valid combinations are: 2,3,4 (using the first 2) 2,3,4 (using the second 2) 2,2,3
 * </pre>
 * <p><b>注意：
 * <br/>Note:</b><ol>
 * <li>数组长度不超过1000。
 * <br/>The length of the given array won't exceed 1000.</li>
 * <li>数组里整数的范围为 [0, 1000]。
 * <br/>The integers in the given array are in the range of [0, 1000].</li>
 * </ol></p>
 */
public class LeetCode611 {

    /**
     * <h6>双指针法</h6>
     * <p><b>解题思路：</b>
     * <br/>利用三角形两边之和大于第三边的特性，即a<=b<=c && a+b>c。
     * <br/>先将数组进行排序，满足a<=b<=c，选定数组较大值作为target，使用二分法，寻找符合a+b>c的结果</p>
     * 
     * @param  nums
     * @return int
     */
    public int triangleNumber(int[] nums) {
        int result = 0;

        if (nums == null || nums.length == 0) {
            return result;
        }

        // 对数组进行排序
        Arrays.sort(nums);

        // 从数组末尾开始选定target
        for (int i = nums.length - 1; i >= 2; i--) {
            // 左指针
            int left = 0;
            // 右指针
            int right = i-1;
            while (left < right) {
                if (nums[left]+nums[right]>nums[i]) {
                    // 因为数组是有序的，符合条件的结果一定在[left, right-1]范围内的数字加上right满足a+b>c
                    result += (right-left);
                    right--;
                } else {
                    left++;
                }
            }
        }

        return result;
    }
}
