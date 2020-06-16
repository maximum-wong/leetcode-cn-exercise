package kstar.leetcode._0027;

/**
 * <h6>双指针法</h6>
 * <p>使用双指针法，右指针指向的元素等于指定元素就跳过。</p>
 */
public class LeetCode27 {

    public int removeElement(int[] nums, int val) {
        // 左指针
        int index = 0;
        for (int i = 0, length = nums.length; i < length; i++) {
            // 右指针所指的元素不等于指定元素
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}