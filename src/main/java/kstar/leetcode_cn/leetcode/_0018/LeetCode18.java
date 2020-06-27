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
     *
     * @param nums
     * @param target
     * @return List<List < Integer>>
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 用于记录结果
        List<List<Integer>> result = new ArrayList<>();

        // 特殊情况判断
        if (nums == null || nums.length < 4) {
            return result;
        }

        // 数组排序
        Arrays.sort(nums);

        // 获取数组长度
        int length = nums.length;

        for (int i = 0; i < length - 3; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // 剪枝
            int min = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (min > target) break;
            int max = nums[length - 1] + nums[length - 2] + nums[length - 3] + nums[length - 4];
            if (max < target) break;

            for (int j = i + 1; j < length - 2; j++) {
                // 去重
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int start = j + 1;
                int end = length - 1;

                // 剪枝
                int tmpMin = nums[i] + nums[j] + nums[start] + nums[start + 1];
                if (tmpMin > target) continue;
                int tmpMax = nums[i] + nums[j] + nums[end] + nums[end - 1];
                if (tmpMax < target) continue;

                while (start < end) {
                    // 计算当前值
                    int current = nums[i] + nums[j] + nums[start] + nums[end];

                    if (current == target) {
                        // 添加结果
                        result.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));

                        // 去重
                        while (start < end && nums[start] == nums[start + 1]) start++;
                        while (start < end && j < end && nums[end] == nums[end - 1]) end--;

                        // 移动指针
                        start++;
                        end--;
                    } else if (current < target) {
                        // 向后移动start指针
                        start++;
                    } else {
                        // 向前移动end指针
                        end--;
                    }
                }
            }
        }
        // 返回结果
        return result;
    }
}
