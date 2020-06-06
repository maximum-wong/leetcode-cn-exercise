package kstar.leetcode;
/**
 * <h6>合并两个有序数组</h6>
 *
 * <p>给你两个有序整数数组 <em>nums1</em> 和 <em>nums2</em>，
 * 请你将 <em>nums2</em> 合并到 <em>nums1</em> 中，使 <em>nums1</em> 成为一个有序数组。
 * <br/>Given two sorted integer arrays <em>nums1</em> and <em>nums2</em>, 
 * merge <em>nums2</em> into <em>nums1</em> as one sorted array.</p>
 * <p>&nbsp;</p>
 * <p><strong>说明:</strong>
 * <br/><strong>Note:</strong></p>
 * <ul>
 * <li>初始化&nbsp;<em>nums1</em> 和 <em>nums2</em> 的元素数量分别为&nbsp;<em>m</em> 和 <em>n </em>。
 * <br/>The number of elements initialized in <em>nums1</em> and <em>nums2</em> are <em>m</em> and <em>n</em> respectively.</li>
 * <li>你可以假设&nbsp;<em>nums1&nbsp;</em>有足够的空间（空间大小大于或等于&nbsp;<em>m + n</em>）来保存 <em>nums2</em> 中的元素。
 * <br/>You may assume that <em>nums1</em> has enough space (size that is greater or equal to <em>m + n</em>) 
 * to hold additional elements from <em>nums2</em>.</li>
 * </ul>
 * <p>&nbsp;</p>
 * <p><strong>示例:</strong></p>
 * <pre>
 * <strong>输入(Input):</strong>
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * <strong>输出(Output):</strong>&nbsp;[1,2,2,3,5,6]
 * </pre>
 */
public class LeetCode88 {

    /**
     * <h6>额外空间法</h6>
     * <p>时间复杂度：O(n)，空间复杂度：O(m+n)</p>
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 申请一个额外空间数组
        int[] result = new int[m + n];
        int i = 0;
        int j = 0;
        int index = 0;
        // 逐个从两个数组中取出元素，来进行比较，较小的放入额外数组中
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                result[index++] = nums1[i++];
            } else {
                result[index++] = nums2[j++];
            }
        }
        // 第一个数组有剩余的情况
        while (i < m) {
            result[index++] = nums1[i++];
        }
        // 第二个数组有剩余的情况
        while (j < n) {
            result[index++] = nums2[j++];
        }
        // 把额外数组中的元素复制进第一个数组中
        index = 0;
        for (j = 0; j < nums1.length; j++) {
            nums1[j] = result[index++];
        }
    }
    
    /**
     * <h6>不使用额外空间法</h6>
     * <p>时间复杂度：O(n)，空间复杂度：O(1)</p>
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int index = m + n - 1;
        // 从后往前，把两个数组中较大的值放入到尾部尾部位置
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[index--] = nums1[i--];
            } else {
                nums1[index--] = nums2[j--];
            }
        }
        // 第一个数组有剩余的情况
        while (i >= 0) {
            nums1[index--] = nums1[i--];
        }
        // 第二个数组有剩余的情况
        while (j >= 0) {
            nums1[index--] = nums2[j--];
        }
    }
}
