package kstar.leetcode_cn.leetcode._0167;

/**
 * <h6>两数之和 II</h6>
 *
 * <p>给定一个已按照 升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * <br/>函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * <br/>说明：返回的下标值（index1 和 index2）不是从零开始的。
 * <br/>你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。</p>
 * <pre><b>Examples: </b>
 * Input: numbers = [2, 7, 11, 15], target = 9; Output: [1,2];
 * Explanation: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * </pre>
 */
public class LeetCode167 {

    /**
     * <h6>双指针法</h6>
     * 
     * <p>时间复杂度：O(n)；空间复杂度：O(1)</p>
     * <p>一个指向数组首位置的左指针和另一个指向数组末尾置的右指针，
     * <br/>每次遍历时，如果左右指针所指向的元素值之和大于目标值，右指针向前移动一位； 反之，则左指针向后移动一位；
     * <br/>如果相等，返回做右指针所指向的数组索引值
     * 
     * @param array
     * @param target
     * @return int[]
     */
    public int[] twoSum4(int[] array, int target) {
        int[] ret = new int[2];
        if (array == null) {
            return ret;
        }
        // 左指针
        int leftPointer = 0;
        // 右指针
        int rightPointer = array.length - 1;
        while (leftPointer < rightPointer) {
            int sum = array[leftPointer] + array[rightPointer];
            if (sum > target) {
                rightPointer--;
            } else if (sum < target) {
                leftPointer++;
            } else {
                ret[0] = leftPointer + 1;
                ret[1] = rightPointer + 1;
                return ret;
            }
        }
        return ret;
    }
}
