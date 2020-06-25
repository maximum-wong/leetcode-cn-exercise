package kstar.leetcode_cn.leetcode._0349;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <h6>排序+二分法</h6>
 * <p>把一个数组进行排序，然后遍历另一个数组，对第一个数组进行二分查找，收集二分查找到的元素</p>
 */
public class Solution4 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        // 对一个数组进行排序
        Arrays.sort(nums2);
        for (int target : nums1) {
            // 通过二分查找，判断该元素是否存在，收集存在的元素
            if (binarySearch(nums2, target)) {
                set.add(target);
            }
        }
        int idx = 0;
        int[] res = new int[set.size()];
        for (int i : set) {
            res[idx++] = i;
        }
        return res;
    }

    /**
     * <h6>二分查找</h6>
     * 
     * @param nums
     * @param target
     * @return
     */
    private boolean binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) >> 1;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        return false;
    }
}
