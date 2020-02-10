package cn.kstar.leetcode;

/**
 * <h6>删除排序数组中的重复项 II</h6>
 *
 * <p>给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * <br/>不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。</p>
 * <pre><b>Examples:</b>
 * &nbsp;&nbsp;给定 nums = [1,1,1,2,2,3], 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 * &nbsp;&nbsp;你不需要考虑数组中超出新长度后面的元素。
 * 
 * &nbsp;&nbsp;给定 nums = [0,0,1,1,1,1,2,3,3], 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
 * &nbsp;&nbsp;你不需要考虑数组中超出新长度后面的元素。
 * </pre>
 */
public class LeetCode80 {

    /**
     * <h6>双指针法<h6>
     *
     * <p>使用双指针法，当快指针指向的元素与其上一个不相同时，重复次数记为1，快指针和慢指针都向前移动；
     * <br/>当快指针指向的元素与其上一个相同且重复次数没有超过2次时，重复次数加1，快指针和慢指针都向前移动；
     * <br/>当快指针指向的元素与其上一个相同且重复次数超过2次时，慢指针不进行任何操作，直接跳过去。
     * <br/>直到遍历到数组的末端，返回结果慢指针。</p>
     * @param  nums
     * @return int
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length <= 2) {
            return nums.length;
        }

        // 返回结果的长度（慢指针）
        int ret = 1;
        // 数字重复数
        int duplicates = 1;
        for (int i = 1, len = nums.length; i < len; i++) {
            // 当遇到不相同元素时，数字重复数置为1，慢指针指向的元素的值为快指针指向元素的值，慢指针向前移动
            if (nums[i] != nums[i - 1]) {
                duplicates = 1;
                nums[ret++] = nums[i];
            } else {
                // 当遇到相同元素时且重复数小于2时，数字重复数加1，慢指针指向的元素的值为快指针指向元素的值，慢指针向前移动
                if (duplicates < 2) {
                    nums[ret++] = nums[i];
                    duplicates++;
                }
                // 当遇到相同元素时且重复数不小于2时，慢指针不进行任何操作，直接跳过去
            }
        }
        return ret;
    }
}
