package kstar.leetcode._0169;

/**
 * <h6>摩尔（Moore）投票法</h6>
 * <p>选定一个候选数，在数组中遍历，如果数组中的元素与候选数相同，计数加一；不同，计数减一，
 * <br/>若计数减至为0，更换候选数，继续计数，返回结果就是多数元素。</p>
 */
public class Solution3 {

    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (candidate == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    candidate = nums[i];
                    count = 1;
                }
            }
        }
        return candidate;
    }
}
