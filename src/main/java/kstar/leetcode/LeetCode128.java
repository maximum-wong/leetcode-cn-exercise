package kstar.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * <h6>最长连续序列
 * <br/>Longest Consecutive Sequence</h6>
 *
 * <p>给定一个未排序的整数数组，找出最长连续序列的长度。
 * <br/>Given an unsorted array of integers, find the length of the longest consecutive elements sequence.</p>
 * <p>要求算法的时间复杂度为 O(n)。
 * <br/>Your algorithm should run in O(n) complexity.</p>
 * <p><strong>示例:</strong>
 * <br/><strong>Example:</strong>
 * </p>
 * <pre>
 * <strong>输入:</strong> [100, 4, 200, 1, 3, 2]
 * <strong>Input:</strong> [100, 4, 200, 1, 3, 2]
 * <strong>输出:</strong> 4
 * <strong>Output:</strong> 4
 * <strong>解释:<strong> 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * <strong>Explanation:<strong> The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * </pre>
 */
public class LeetCode128 {

    /**
     * <h6>查表法</h6>
     * 
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> numsSet = new HashSet<>();
        for (Integer num : nums) {
            numsSet.add(num);
        }

        int longest = 0;
        for (Integer num : nums) {
            if (numsSet.remove(num)) {
                // 当前元素向左边搜索
                int currentLongest = 1;
                int current = num;
                while (numsSet.remove(current - 1)) {
                    current--;
                }
                currentLongest += (num - current);
                // 当前元素向右边搜索
                current = num;
                while (numsSet.remove(current + 1)) {
                    current++;
                }
                currentLongest += (current - num);
                // 搜索完后更新longest
                longest = (longest > currentLongest) ? longest : currentLongest;
            }
        }
        return longest;
    }
}
