package kstar.leetcode_cn.leetcode._0031;

/**
 * <h6>线性扫描法</h6>
 * <p>解题思路：先从后往前比较，找到降序区间；为了满足下一个属与当前数排列紧密的要求，
 * 需要从后往前寻找一个比降序区间左端点临近点（i-1）要大的一个数字并进行交换，随后对降序区间进行交换操作。</p>
 */
public class Solution {

    public void nextPermutation(int[] nums) {
        if (nums == null) {
            return;
        }

        int i = nums.length - 1;
        int k = i;
        // 获得降序区间
        while (i > 0 && nums[i] <= nums[i - 1]) {
            i--;
        }
        // 寻找比降序区间左端点外临近数还要大的数并交换
        if (i > 0) {
            int j = k;
            while (nums[j] <= nums[i - 1]) {
                j--;
            }
            swap(nums, i - 1, j);
        }
        // 交换降序区间的数字
        while (i < k) {
            swap(nums, i++, k--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
