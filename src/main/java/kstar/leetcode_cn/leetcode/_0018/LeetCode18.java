package kstar.leetcode_cn.leetcode._0018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h6>四数之和</h6>
 *
 * <p>给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a, b, c 和 d, 使得 a + b + c + d 的值与 target 相等？
 * <br/>找出所有满足条件且不重复的四元组。
 * <br/>注意：答案中不可以包含重复的四元组。</p>
 * <pre><b>Examples: </b>
 * <br/>给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <br/>满足要求的四元组集合为：[ [-1,  0, 0, 1], [-2, -1, 1, 2], [-2,  0, 0, 2] ]
 * </pre>
 */
public class LeetCode18 {

    /**
     * <h6>双指针法</h6>
     *
     * <p>使用双指针法，将四数之和转为三数之和。</p>
     * @param  nums
     * @param  target
     * @return List<List<Integer>>
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if ((nums == null) || (nums.length < 3)) {
            return result;
        }

        // 排序数组
        Arrays.sort(nums);

        int length = nums.length;
        for (int i = 0; i < length; i++) {
            // 相邻元素如果相同，则跳过，去除重复元素
            if ((i > 0) && (nums[i] == nums[i - 1])) {
                continue;
            }
            for (int j = i + 1; j < length; j++) {
                // 相邻元素如果相同，则跳过，去除重复元素
                if ((j > 0) && (nums[j] == nums[j - 1])) {
                    continue;
                }
                // 左指针
                int left = j + 1;
                // 右指针
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // 相邻元素如果相同，则跳过，去除重复元素
                        while ((left < right) && (nums[left] == nums[left + 1])) {
                            left++;
                        }
                        while ((left < right) && (nums[right] == nums[right - 1])) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right++;
                    }
                }
            }
        }
        return result;
    }
}
