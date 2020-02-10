package cn.kstar.leetcode;

/**
 * <h6>在排序数组中查找元素的第一个和最后一个位置</h6>
 * 
 * <p>给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <br/>你的算法时间复杂度必须是 O(log n) 级别。如果数组中不存在目标值，返回 [-1, -1]。</p>
 * <pre><b>Explanation:</b>
 * Input: nums = [5,7,7,8,8,10], target = 8; Output: [3,4]
 * 
 * Input: nums = [5,7,7,8,8,10], target = 6; Output: [-1,-1]
 * </pre>
 */
public class LeetCode34 {

    /**
     * <h6>二分查找法</h6>
     * 
     * @param  array
     * @param  target
     * @return int[]
     */
    public int[] searchRange(int[] array, int target) {
        int[] ret = { -1, -1 };
        if (array == null || array.length == 0) {
            return ret;
        }
        // 左边界
        int left = 0;
        // 右边界
        int right = array.length;
        // 中间位置
        int mid = (left + right) / 2;
        // 任意目标元素的位置
        int position = -1;
        while (left < right) {
            if (array[mid] > target) {
                if (right == mid) {
                    break;
                }
                right = mid;
                mid = (left + right) / 2;
            } else if (array[mid] < target) {
                if (left == mid) {
                    break;
                }
                left = mid;
                mid = (left + right) / 2;
            } else {
                position = mid;
                break;
            }
        }
        if (position == -1) {
            return ret;
        } else {
            int firstPosition = position;
            int lastPosition = position;
            // 寻找第一个位置的目标元素
            while ((firstPosition > 0) && (array[firstPosition - 1] == target)) {
                firstPosition--;
            }
            // 寻找最后一个位置的目标元素
            while ((lastPosition < array.length - 1) && (array[lastPosition + 1] == target)) {
                lastPosition++;
            }
            return new int[] { firstPosition, lastPosition };
        }
    }
}
