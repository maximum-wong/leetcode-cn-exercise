package cn.kstar.leetcode;

/**
 * <h6>跳跃游戏
 * <br/>Jump Game</h6>
 *
 * <p>给定一个非负整数数组，你最初位于数组的第一个位置。
 * <br/>Given an array of non-negative integers, you are initially positioned at the first index of the array.</p>
 * <p>数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <br/>Each element in the array represents your maximum jump length at that position.</p>
 * <p>判断你是否能够到达最后一个位置。
 * <br/>Determine if you are able to reach the last index.</p>
 * <p><strong>示例&nbsp;1:</strong>
 * <br/><strong>Example&nbsp;1:</strong></p>
 * <pre>
 * <strong>输入(Input):</strong> [2,3,1,1,4]
 * <strong>输出(Output):</strong> true
 * <strong>解释(Explanation):</strong> 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * </pre>
 * <p><strong>示例&nbsp;2:</strong>
 * <br/><strong>Example&nbsp;2:</strong></p>
 * <pre>
 * <strong>输入(Input):</strong> [3,2,1,0,4]
 * <strong>输出(Output):</strong> false
 * <strong>解释(Explanation):</strong> 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * You will always arrive at index 3 no matter what. Its maximum
 * jump length is 0, which makes it impossible to reach the last index.
 * </pre>
 */
public class LeetCode55 {

    /**
     * <h6>贪心法</h6>
     * 
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int curPos = 0; // 当前位置
        int maxPos = 0; // 最大位置
        for (int len = nums.length; curPos < len; curPos++) {
            // 最大位置小于当前位置时，是无法跳到最大位置的
            if (curPos > maxPos) {
                return false;
            }
            // 尽可能地取最大位置
            if (nums[curPos] + curPos > maxPos) {
                maxPos = nums[curPos] + curPos;
            }
            // 最大位置大于等于数组最大索引时，是可以跳到最大位置的
            if (maxPos >= len - 1) {
                return true;
            }
        }
        return true;
    }

}
