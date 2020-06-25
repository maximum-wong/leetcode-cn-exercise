package kstar.leetcode_cn.leetcode._0075;

/**
 * <h6>三指针法</h6>
 * <p>时间复杂度：O(n)；空间复杂度：O(1)</p>
 * <p>使用三指针法，p0代表0的最右边界，p2代表2的最左边界，current代表当前元素。<br/>
 * 随着数组移动current指针，若current指向的元素为0，则将p0指向的元素与current指向的元素进行交换；<br/>
 * 若current指向的元素为2，则将p2指向的元素与current指向的元素进行交换 .</p>
 */
public class Solution {

    public void sortColors(int[] nums) {

        if (nums == null || nums.length == 0) {
            return;
        }

        // 指向0的指针，数字0的最右边界
        int p0 = 0;
        // 指向2的指针，数字2的最左边界
        int p2 = nums.length - 1;
        // 当前指针
        int current = 0;

        int tmp = 0;
        while (current <= p2) {
            // 当前指针指向的数字为0时，与p0指针指向的数字进行交换
            if (nums[current] == 0) {
                tmp = nums[p0];
                nums[p0] = nums[current];
                nums[current] = tmp;
                p0++;
                current++;
            // 当前指针指向的数字为2时，与p2指针指向的数字进行交换
            } else if (nums[current] == 2) {
                tmp = nums[p2];
                nums[p2] = nums[current];
                nums[current] =tmp;
                p2--;
            } else {
                current++;
            }
        }
    }

}
